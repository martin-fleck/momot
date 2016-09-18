package at.ac.tuwien.big.momot.examples.tse.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

public class ATL2Model {
	public static IModel toModel(String atlFile) throws FileNotFoundException, ATLCoreException {
		AtlParser parser = new AtlParser();

		InputStream stream = new FileInputStream(atlFile);
		IModel parseToModel = parser.parseToModel(stream);
		return parseToModel;
	}
}
