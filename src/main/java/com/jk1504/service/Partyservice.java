<<<<<<< HEAD
package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jk1504.dao.Partymapper;
import com.jk1504.entity.Joinparty;
import com.jk1504.entity.Party;
import com.js1504.exception.taskwcrsexception;
import com.js1504.exception.taskxgexception;

@Service
public class Partyservice implements Partyservicejk{
	@Autowired
	private Partymapper partymapper;
	
	@Override
	public boolean fabuParty(Party party) {
		try {
			int boolpd=partymapper.insertparty(party);
			if (boolpd<=0) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Party> yjfbParty(Integer dbid) {
		List<Party> list=new ArrayList<Party>();
		try {
		list=partymapper.returnparty(dbid);
			
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean scfbParty(Party party) {
		try {
			int boolpd=partymapper.deleteparty(party);
			partymapper.deletepartybyowner(party);
			if (boolpd<=0) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean  wcParty(Joinparty joinparty)throws taskwcrsexception,taskxgexception {
		try {
			int boolpd=partymapper.insertparties(joinparty);
			if (boolpd<=0) {
				throw new taskxgexception("Ìá½»»î¶¯Ê§°Ü");
			}
			else
			{
				int boww=partymapper.inupdateparties(joinparty.getTaskid());
				if (boww<0) {
					throw new taskwcrsexception("Ôö¼ÓÈËÊıÊ§°Ü");
				}
				else
				{
					return true;
				}
			}
		} 
		catch (taskwcrsexception e1) {
			throw e1;
		}
		catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			throw new taskxgexception("ÈÎÎñÌá½»´íÎó"+e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean csParty(Joinparty joinparty)throws taskwcrsexception,taskxgexception {
		try {
			int boolpd=partymapper.deleteparties(joinparty);
			if (boolpd<=0) {
				throw new taskxgexception("É¾³ıÈÎÎñÊ§°Ü");
			}
			else
			{
				int boww=partymapper.deupdateparties(joinparty.getTaskid());
				if (boww<0) {
					throw new taskwcrsexception("¼õÉÙÈËÊıÊ§°Ü");
				}
				else
				{
					return true;
				}
			}
		} 
		catch (taskwcrsexception e1) {
			throw e1;
		}
		catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			throw new taskxgexception("ÈÎÎñÉ¾³ı´íÎó"+e.getMessage());
		}
	}

	@Override
	public List<Party>fbhdParty(Integer stateid,Integer dbid) {
		List<Party> alltasks=new ArrayList<Party>();
		try {
			alltasks=partymapper.returnparties();
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		if (alltasks.isEmpty()) {
			return alltasks;
		}
		if (stateid.equals(0)) {
			return alltasks;
		}
		List<Party> wwctasks=new ArrayList<Party>();
		List<Party> ywctasks=new ArrayList<Party>();
			for(Party tasks:alltasks)
			{
				Joinparty tasks2;
				tasks.setDbid(dbid);
				try 
				{
					tasks2=partymapper.sfjoin(tasks);
					if (tasks2.getSfjoinp().equals(0)) 
					{
						wwctasks.add(tasks);
					} else {
						ywctasks.add(tasks);
					}
				} catch (Exception e) 
				{
					// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
					e.printStackTrace();
				}
				
			}
		if (stateid.equals(1)) 
		{
			return wwctasks;
		}
		
		if (stateid.equals(2)) 
		{
			return ywctasks;
		}
		return alltasks;
	}
}
=======
package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jk1504.dao.Partymapper;
import com.jk1504.entity.Joinparty;
import com.jk1504.entity.Party;
import com.jk1504.exception.taskwcrsexception;
import com.jk1504.exception.taskxgexception;

@Service
public class Partyservice implements Partyservicejk{
	@Autowired
	private Partymapper partymapper;
	
	@Override
	public boolean fabuParty(Party party) {
		try {
			int boolpd=partymapper.insertparty(party);
			if (boolpd<=0) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Party> yjfbParty(Integer dbid) {
		List<Party> list=new ArrayList<Party>();
		try {
		list=partymapper.returnparty(dbid);
			
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean scfbParty(Party party) {
		try {
			int boolpd=partymapper.deleteparty(party);
			partymapper.deletepartybyowner(party);
			if (boolpd<=0) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean  wcParty(Joinparty joinparty)throws taskwcrsexception,taskxgexception {
		try {
			int boolpd=partymapper.insertparties(joinparty);
			if (boolpd<=0) {
				throw new taskxgexception("Ìá½»»î¶¯Ê§°Ü");
			}
			else
			{
				int boww=partymapper.inupdateparties(joinparty.getTaskid());
				if (boww<0) {
					throw new taskwcrsexception("Ôö¼ÓÈËÊıÊ§°Ü");
				}
				else
				{
					return true;
				}
			}
		} 
		catch (taskwcrsexception e1) {
			throw e1;
		}
		catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			throw new taskxgexception("ÈÎÎñÌá½»´íÎó"+e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean csParty(Joinparty joinparty)throws taskwcrsexception,taskxgexception {
		try {
			int boolpd=partymapper.deleteparties(joinparty);
			if (boolpd<=0) {
				throw new taskxgexception("É¾³ıÈÎÎñÊ§°Ü");
			}
			else
			{
				int boww=partymapper.deupdateparties(joinparty.getTaskid());
				if (boww<0) {
					throw new taskwcrsexception("¼õÉÙÈËÊıÊ§°Ü");
				}
				else
				{
					return true;
				}
			}
		} 
		catch (taskwcrsexception e1) {
			throw e1;
		}
		catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			throw new taskxgexception("ÈÎÎñÉ¾³ı´íÎó"+e.getMessage());
		}
	}

	@Override
	public List<Party>fbhdParty(Integer stateid,Integer dbid) {
		List<Party> alltasks=new ArrayList<Party>();
		try {
			alltasks=partymapper.returnparties();
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		if (alltasks.isEmpty()) {
			return alltasks;
		}
		if (stateid.equals(0)) {
			return alltasks;
		}
		List<Party> wwctasks=new ArrayList<Party>();
		List<Party> ywctasks=new ArrayList<Party>();
			for(Party tasks:alltasks)
			{
				Joinparty tasks2;
				tasks.setDbid(dbid);
				try 
				{
					tasks2=partymapper.sfjoin(tasks);
					if (tasks2.getSfjoinp().equals(0)) 
					{
						wwctasks.add(tasks);
					} else {
						ywctasks.add(tasks);
					}
				} catch (Exception e) 
				{
					// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
					e.printStackTrace();
				}
				
			}
		if (stateid.equals(1)) 
		{
			return wwctasks;
		}
		
		if (stateid.equals(2)) 
		{
			return ywctasks;
		}
		return alltasks;
	}
}
>>>>>>> parent of 9adc572... Revert "ä¿®å¤äº†qqå·ï¼Œç”µè¯å·ï¼Œå­¦å·æ•°æ®æº¢å‡ºã€‚"
