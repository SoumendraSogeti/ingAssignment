package com.ing.assignment.mapper;

import com.ing.assignment.domain.Account;
import com.ing.assignment.dto.AccountDTO;
import com.ing.assignment.repo.AccountsEntity;

public class AccountMapper {

    public static Account toAccountDomain(final AccountsEntity accountsEntity) {
        return Account.builder().account(accountsEntity.getAccount())
                .balance(accountsEntity.getBalance())
                .created(accountsEntity.getCreated())
                .user("User"+ accountsEntity.getUserId())
                .debitCards(DebitCardMapper.toDebitCardList(accountsEntity.getDebitCardEntities())).build();
    }

    public static AccountDTO toAccountDTO(final Account Account) {
        return AccountDTO.builder().account(Account.getAccount())
                .balance(Account.getBalance())
                .created(Account.getCreated())
                .user(Account.getUser())
                .debitCards(Account.getDebitCards()).build();
    }
}
