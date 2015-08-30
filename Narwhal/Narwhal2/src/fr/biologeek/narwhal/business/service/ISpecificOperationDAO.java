package fr.biologeek.narwhal.business.service;

import java.util.Date;
import java.util.List;

import fr.biologeek.narwhal.business.entities.Compte;
import fr.biologeek.narwhal.business.entities.FinancialOperation;
import fr.biologeek.narwhal.business.entities.Operation;
import fr.biologeek.narwhal.exceptions.DAOReadException;

public interface ISpecificOperationDAO {

	
	public List<FinancialOperation> readDateToDate (Date begin, Date end) throws DAOReadException;
	public List<FinancialOperation> readByCompte (Compte compte) throws DAOReadException;
}
