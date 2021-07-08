package service;

import com.ing.assignment.domain.Account;
import com.ing.assignment.domain.DebitCard;
import com.ing.assignment.repo.*;
import com.ing.assignment.service.CustomerService;
import com.ing.assignment.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class CustomerServiceImplTest {


    private AccountsRepository accountsRepository =mock(AccountsRepository.class);
    private DebitCardsRepository debitCardsRepository =mock(DebitCardsRepository.class);
    private UserAgreementRepository userAgreementRepository =mock(UserAgreementRepository.class);
    private CustomerServiceImpl customerService=mock(CustomerServiceImpl.class) ;



    @Test
    public void fetchAccountTest() {
        AccountsEntity accountsEntity = generateAccountEntity();
        when(accountsRepository.findById("IBAN1234567891")).thenReturn(Optional.of(accountsEntity));
        customerService.fetchAccounts("IBAN1234567891");
        verify(accountsRepository).findById("IBAN1234567891");


    }

    @Test
    public void fetchDebitCardsTest() {
        DebitCardsEntity debitCardsEntity = getDebitCardEntity();
        /*when(debitCardsRepository.findDebitCardByCardNumber(1111)).thenReturn(Optional.ofNullable(debitCardsEntity));
        DebitCard debitCard = customerService.fetchDebitCards(1111);
        System.out.println(debitCard);
        assertThat(debitCard.getStatus()).isEqualTo("IBAN1234567890");*/
    }

    private AccountsEntity generateAccountEntity(){
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
        accountsEntity.setUserId(1);
        accountsEntity.setDebitCardEntities(debitCardsEntityList);
        return accountsEntity;
    }
    private DebitCardsEntity getDebitCardEntity(){
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
        return debitCardsEntity;
    }





}
