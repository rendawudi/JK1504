package com.jk1504.dao;

import java.util.List;

import com.jk1504.entity.Joinparty;
import com.jk1504.entity.Party;

public interface Partymapper {
	public int insertparty(Party party) throws Exception;
	public List<Party> returnparty(Integer dbid) throws Exception;
	public int deleteparty(Party party) throws Exception;
	public int deletepartybyowner(Party party)throws Exception;
	public int insertparties(Joinparty joinparty) throws Exception;
	public int inupdateparties(Integer taskid) throws Exception;
	public int deleteparties(Joinparty joinparty) throws Exception;
	public int deupdateparties(Integer taskid) throws Exception;
	public Party returnpartiessx(Integer taskid) throws Exception;
	public List<Party> returnparties() throws Exception;
	public Joinparty sfjoin(Party party) throws Exception;
}
