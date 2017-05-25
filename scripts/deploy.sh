#!/bin/bash
set -ev # Exit with nonzero exit code if anything fails

# SOURCE_BRANCH="develop"
TARGET_BRANCH="gh-pages"

# Pull requests and commits to other branches shouldn't try to deploy, just build to verify
# if [ "$TRAVIS_PULL_REQUEST" != "false" -o "$TRAVIS_BRANCH" != "$SOURCE_BRANCH" ]; then
if [ "$TRAVIS_PULL_REQUEST" != "false" ]; then
    echo "Skipping deployment."
    exit 0
fi

# Save some useful information
REPO=`git config remote.origin.url`
SSH_REPO=${REPO/https:\/\/github.com\//git@github.com:}
SHA=`git rev-parse --verify HEAD`

# Clone the existing gh-pages for this repo into martin-fleck/gh-pages
cd $TRAVIS_BUILD_DIR/..
git clone --depth=50 --branch=gh-pages https://github.com/martin-fleck/momot.git gh-pages
cd gh-pages

# Clean out latest development site
rm -rf eclipse/updates/latest/develop/** || exit 0

# Copy compiled update site to gh-pages
cp -rf $TRAVIS_BUILD_DIR/releng/at.ac.tuwien.big.momot.update/target/repository/** eclipse/updates/latest/develop/
cp -f eclipse/updates/archive/1.0.0.201605221935/index.md eclipse/updates/latest/develop/

# Now let's go have some fun with the cloned repo
git config user.name "Travis CI"
git config user.email "$COMMIT_AUTHOR_EMAIL"

# If there are no changes to the compiled out (e.g. this is a README update) then just bail.
if `git diff --quiet` ; then
    echo "No changes to the output on this push; exiting."
    exit 0
fi

# Commit the "changes", i.e. the new version.
# The delta will show diffs between new and old versions.
git add -A .
git commit -m "Deploy development update site to GitHub Pages: ${SHA}"

# Get the deploy key by using Travis's stored variables to decrypt deploy_key.enc
ENCRYPTED_KEY_VAR="encrypted_${ENCRYPTION_LABEL}_key"
ENCRYPTED_IV_VAR="encrypted_${ENCRYPTION_LABEL}_iv"
ENCRYPTED_KEY=${!ENCRYPTED_KEY_VAR}
ENCRYPTED_IV=${!ENCRYPTED_IV_VAR}
openssl aes-256-cbc -K $ENCRYPTED_KEY -iv $ENCRYPTED_IV -in deploy_key.enc -out deploy_key -d
chmod 600 deploy_key
eval `ssh-agent -s`
ssh-add deploy_key

# Now that we're all set up, we can push.
git push $SSH_REPO $TARGET_BRANCH
