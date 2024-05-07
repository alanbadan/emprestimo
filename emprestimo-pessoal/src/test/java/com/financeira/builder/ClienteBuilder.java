package com.financeira.builder;

import com.financeira.entity.Cliente;

public class ClienteBuilder {
	
	public static Cliente build() {
		return new Cliente(31, "907.657.990-30", "Carlos Andre", 2000.0, "Sp");
	}
	
	public static Cliente build(Double renda) {
		return new Cliente(31, "907.657.990-30", "Carlos Andre", renda, "Sp");
	}

}
