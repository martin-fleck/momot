#!/bin/bash
set -ev

# ensure that we are in build dir
cd $TRAVIS_BUILD_DIR

# delete all old examples and (re-)create directory if necessary
rm -rf plugins/at.ac.tuwien.big.momot.examples.wizards/examples
mkdir -p plugins/at.ac.tuwien.big.momot.examples.wizards/examples/

# zip CRA example
cd examples/at.ac.tuwien.big.momot.examples.cra/
zip -r icmt.tool.momot.demo.zip ./
mv -f icmt.tool.momot.demo.zip ../../plugins/at.ac.tuwien.big.momot.examples.wizards/examples/
