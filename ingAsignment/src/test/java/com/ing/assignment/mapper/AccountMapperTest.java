package com.ing.assignment.mapper;


import com.ing.assignment.domain.Account;
import com.ing.assignment.domain.DebitCards;
import com.ing.assignment.dto.AccountDTO;
import com.ing.assignment.repo.AccountsEntity;
import com.ing.assignment.repo.DebitCardsEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AccountMapperTest {

    @Test
    public void toAccountDomainTest(){

        DebitCardsEntity debitCardsEntity = new DebitCardsEntity();
        debitCardsEntity.setCardNumber(1111);
        debitCardsEntity.setAtmLimit(3000);
        debitCardsEntity.setAtmPeriodUnit("PER_WEEK");
        debitCardsEntity.setContactless(true);
        debitCardsEntity.setId(1111);
        debitCardsEntity.setPosLimit(50);
        debitCardsEntity.setPosPeriodUnit("PER_MONTH");
        debitCardsEntity.setSequenceNumber(1);
        debitCardsEntity.setStatus("ACTIVE");
        debitCardsEntity.setAccount("IBAN1234567890");
        debitCardsEntity.setCardHolderId("User1");

        List<DebitCardsEntity> debitCardsEntityList = new ArrayList<>();
        debitCardsEntityList.add(debitCardsEntity);

        AccountsEntity accountsEntity = new AccountsEntity();
        accountsEntity.setAccount("IBAN1234567890");
        accountsEntity.setBalance(10);
        accountsEntity.setCreated(LocalDate.of(2021,07,01));
        accountsEntity.setUserId(1);
        accountsEntity.setDebitCardEntities(debitCardsEntityList);

        Account account = AccountMapper.toAccountDomain(accountsEntity);
        assertThat(accountsEntity.getAccount()).isEqualTo(account.getAccount());
        assertThat(accountsEntity.getBalance()).isEqualTo(account.getBalance());
        assertThat(accountsEntity.getCreated()).isEqualTo(account.getCreated());
        assertThat("User"+accountsEntity.getUserId()).isEqualTo(account.getUser());
        assertThat(accountsEntity.getDebitCardEntities().size()).isEqualTo(account.getDebitCards().size());
        assertThat(debitCardsEntity.getCardNumber()).isEqualTo(account.getDebitCards().get(0).getCardId());
    }
    @Test
    public void toAccountDTOTest(){
        List<DebitCards> debitCardList = new ArrayList<>();
        debitCardList.add(new DebitCards(111));

        Account account = Account.builder().account("IBAN1234567890")
                .user("User1")
                .balance(100)
                .debitCards(debitCardList).build();
        AccountDTO accountDTO = AccountMapper.toAccountDTO(account);
        assertThat(account.getAccount()).isEqualTo(accountDTO.getAccount());
        assertThat(account.getBalance()).isEqualTo(accountDTO.getBalance());
        assertThat(account.getUser()).isEqualTo(accountDTO.getUser());
        assertThat(account.getCreated()).isEqualTo(accountDTO.getCreated());
        assertThat(account.getDebitCards().size()).isEqualTo(accountDTO.getDebitCards().size());
        assertThat(account.getDebitCards().get(0).getCardId()).isEqualTo(accountDTO.getDebitCards().get(0).getCardId());
    }
}
