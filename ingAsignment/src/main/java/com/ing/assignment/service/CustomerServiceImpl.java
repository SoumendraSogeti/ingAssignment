package com.ing.assignment.service;

import com.ing.assignment.domain.Account;
import com.ing.assignment.domain.AgreementOverview;
import com.ing.assignment.domain.Agreements;
import com.ing.assignment.domain.DebitCard;
import com.ing.assignment.mapper.AccountMapper;
import com.ing.assignment.mapper.DebitCardMapper;
import com.ing.assignment.repo.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.ing.assignment.mapper.AccountMapper.toAccountDomain;
import static com.ing.assignment.mapper.AgreementMapper.toAgreementDomain;
import static com.ing.assignment.mapper.DebitCardMapper.toDebitCardDomain;

@Component
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    AccountsRepository accountsRepository;
    DebitCardsRepository debitCardsRepository;
    UserAgreementRepository userAgreementRepository;
    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Override
    public Account fetchAccounts(String accountId) {

        try {
            return toAccountDomain(accountsRepository.findById(accountId).get());
        }catch (Exception exception){
            log.error("No data found for the account {}",accountId);
            throw new EntityNotFoundException();
        }
    }

    @Override
    public DebitCard fetchDebitCards(int debitCardNumber) {
        try{
            return toDebitCardDomain(debitCardsRepository.findDebitCardByCardNumber(debitCardNumber));
        }catch (Exception exception){
            log.error("No data found for the cardNumber {}",debitCardNumber);
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Agreements> fetchUserAgreement(int user) {
        List<UserAgreementEntity> userAgreementEntity = userAgreementRepository.findAgreementByUser(user);
        return toAgreementDomain(userAgreementEntity);
    }

    @Override
    public AgreementOverview fetchAgreementOverview(int user) {


        List<UserAgreementEntity> userAgreementEntityList ;
        try{
            userAgreementEntityList = userAgreementRepository.findAgreementByUser(user);
            log.info("userAgreementEntityList {}",userAgreementEntityList.size());
            log.info("userAgreementEntityList 1 {}",userAgreementEntityList.get(0).getAgreementAccount());
            log.info("userAgreementEntityList 2 {}",userAgreementEntityList.get(1).getAgreementAccount());
        }catch (Exception exception){
            log.error("No data found for the user {}",user);
            throw new EntityNotFoundException();
        }
        AgreementOverview agreementOverview = new AgreementOverview();
        agreementOverview.setUser(Integer.toString(user));
        for(UserAgreementEntity userAgreementEntity1 : userAgreementEntityList){
            List<String> accountList = new ArrayList<>();
            List<DebitCard> debitCardList = new ArrayList<>();
            String accountId = userAgreementEntity1.getAgreementType()+ userAgreementEntity1.getAgreementAccount();
            log.info("accountId 1 {}",accountId);
            AccountsEntity accountsEntity = accountsRepository.findById(accountId.trim()).orElseThrow(EntityNotFoundException::new);
            Account account = AccountMapper.toAccountDomain(accountsEntity);
            accountList.add(account.getAccount());
            List<DebitCardsEntity> debitCardEntities = accountsEntity.getDebitCardEntities();
            log.info("debitCardEntities 1 {}",debitCardEntities.size());
            for(DebitCardsEntity debitCardsEntity : debitCardEntities){
                DebitCardsEntity cardsEntity;
                try{
                    log.info("debitCardsEntity.getCardNumber 1 {}",debitCardsEntity.getCardNumber());
                     cardsEntity = debitCardsRepository.findDebitCardByCardNumber(debitCardsEntity.getCardNumber());
                }catch (Exception exception){
                    log.error("No data found for the card number {}",debitCardsEntity.getCardNumber());
                    throw new EntityNotFoundException();
                }
                if(cardsEntity != null){
                    DebitCard debitCard = DebitCardMapper.toDebitCardDomain(cardsEntity);
                    debitCardList.add(debitCard);
                }
            }
            agreementOverview.setAccountNumbers(accountList);
            agreementOverview.setDebitCards(account.getDebitCards());
            agreementOverview.setDebitCard(debitCardList);

        }
        return agreementOverview;
    }


}
