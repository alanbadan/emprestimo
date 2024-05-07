package com.financeira.builder;

import com.financeira.dto.ClienteRequestDto;

public class ClienteRequestDtoTest {
	
	public static ClienteRequestDto build() {
		return new ClienteRequestDto(31, "907.657.990-30", "Carlos Andre", 2000.0, "Sp");
	}

}
