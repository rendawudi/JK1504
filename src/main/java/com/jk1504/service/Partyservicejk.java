package com.jk1504.service;

import java.util.List;

import com.jk1504.entity.Joinparty;
import com.jk1504.entity.Party;
import com.js1504.exception.taskwcrsexception;
import com.js1504.exception.taskxgexception;

public interface Partyservicejk {
	public boolean fabuParty(Party party);
	public List<Party> yjfbParty(Integer dbid);
	public boolean scfbParty(Party party);
	public boolean wcParty(Joinparty joinparty)throws taskwcrsexception,taskxgexception;
	public boolean csParty(Joinparty joinparty)throws taskwcrsexception,taskxgexception;
	public List<Party>fbhdParty(Integer stateid,Integer dbid);
}
