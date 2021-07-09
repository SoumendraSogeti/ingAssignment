package service;

import com.ing.assignment.repo.*;
import com.ing.assignment.service.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


public class CustomerServiceImplTest {


    private AccountsRepository accountsRepository =mock(AccountsRepository.class);
    private DebitCardsRepository debitCardsRepository =mock(DebitCardsRepository.class);
    private UserAgreementRepository userAgreementRepository =mock(UserAgreementRepository.class);
    private CustomerServiceImpl customerService=mock(CustomerServiceImpl.class) ;



    //@Test
    public void fetchAccountTest() {
        AccountsEntity accountsEntity = generateAccountEntity();
        when(accountsRepository.findById("IBAN1234567891")).thenReturn(Optional.of(accountsEntity));
        customerService.fetchAccounts("IBAN1234567891");
        verify(accountsRepository).findById("IBAN1234567891");


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






}
