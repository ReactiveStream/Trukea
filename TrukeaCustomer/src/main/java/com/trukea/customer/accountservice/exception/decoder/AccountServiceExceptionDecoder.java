package com.trukea.customer.accountservice.exception.decoder;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trukea.customer.exception.TrukeaError;
import com.trukea.customer.exception.UserNotFoundException;
import com.trukea.customer.exception.VerificationCodeMismatchException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class AccountServiceExceptionDecoder  implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		
		System.out.println(response.body().toString());
		
		Exception exception=null;
		Reader reader=null;
		ObjectMapper mapper=null;
		List<TrukeaError> errors=null;
		
		if(response.status()==HttpStatus.CONFLICT.value()) {
		try {
			mapper=new ObjectMapper();
			reader=response.body().asReader(Charset.forName("utf-8"));
			errors=mapper.readValue(reader, new TypeReference<List<TrukeaError>>() {});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		exception=new VerificationCodeMismatchException(errors);
		
		}
		
		
		if(response.status()==HttpStatus.NOT_FOUND.value()) {
			try {
				mapper=new ObjectMapper();
				reader=response.body().asReader(Charset.forName("utf-8"));
				errors=mapper.readValue(reader, new TypeReference<List<TrukeaError>>() {});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			exception=new UserNotFoundException(errors);
			
			
		}
		
		
		
		
		return exception;
	}

}
