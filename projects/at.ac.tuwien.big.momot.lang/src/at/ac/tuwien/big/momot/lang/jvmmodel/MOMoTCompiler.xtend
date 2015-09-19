package at.ac.tuwien.big.momot.lang.jvmmodel

import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XAbstractFeatureCall

class MOMoTCompiler extends XbaseCompiler {
	
	override protected compileWithJvmConstructorCall(XBlockExpression obj, ITreeAppendable apendable) {
		super.compileWithJvmConstructorCall(obj, apendable)
	}
	
	override protected doInternalToJavaStatement(XExpression obj, ITreeAppendable appendable, boolean isReferenced) {
		super.doInternalToJavaStatement(obj, appendable, isReferenced)
	}
	
	override protected appendArgument(XExpression argument, ITreeAppendable b, boolean doLineWrappingIfSourceWasWrapped) {
		super.appendArgument(argument, b, doLineWrappingIfSourceWasWrapped)
	}
	
	override protected appendTypeArguments(XAbstractFeatureCall call, ITreeAppendable original) {
		super.appendTypeArguments(call, original)
	}
	
}