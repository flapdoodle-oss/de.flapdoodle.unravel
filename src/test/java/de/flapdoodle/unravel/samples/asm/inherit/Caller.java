package de.flapdoodle.unravel.samples.asm.inherit;

import java.util.function.Supplier;

public class Caller {

	ExtendsExtends extendsExtends=new ExtendsExtends();
	AbstractExtends abstractExtends=extendsExtends;
	Base base=abstractExtends;
	AbstractBase abstractBase=base;
	
	Supplier<String> supplier=abstractExtends;
	LocalInterface localInterface=abstractExtends;
	
	public void allMethodsOfExtendsExtends() {
		extendsExtends.abstractAbstractBaseMethod();
		extendsExtends.abstractBaseMethod();
		extendsExtends.baseMethod();
		extendsExtends.get();
		extendsExtends.interfaceMethod();
		extendsExtends.defaultMethod();
		extendsExtends.toString();
	}

	public void allMethodsOfAbstractExtends() {
		abstractExtends.abstractAbstractBaseMethod();
		abstractExtends.abstractBaseMethod();
		abstractExtends.baseMethod();
		abstractExtends.get();
		abstractExtends.interfaceMethod();
		abstractExtends.defaultMethod();
		abstractExtends.toString();
	}
}
