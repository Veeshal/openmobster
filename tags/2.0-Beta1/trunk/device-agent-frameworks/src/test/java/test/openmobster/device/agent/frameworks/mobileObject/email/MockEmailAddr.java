/**
 * Copyright (c) {2003,2010} {openmobster@gmail.com} {individual contributors as indicated by the @authors tag}.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package test.openmobster.device.agent.frameworks.mobileObject.email;

import java.io.Serializable;

/**
 * Represents an Email address associated with an email
 * 
 * @author openmobster@gmail.com
 *
 */
public class MockEmailAddr implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 61840221873903428L;
	
	/**
	 * 
	 */
	private String address = null;
	
	/**
	 * 
	 *
	 */
	public MockEmailAddr()
	{
		
	}
	
	/**
	 * 
	 * @param address
	 */
	public MockEmailAddr(String address)
	{
		this.address = address;
	}

	/**
	 * 
	 * @return
	 */
	public String getAddress() 
	{
		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) 
	{
		this.address = address;
	}	
}