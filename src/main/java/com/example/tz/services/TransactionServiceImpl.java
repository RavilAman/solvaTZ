package com.example.tz.services;

import com.example.tz.dao.entities.LimitEntity;
import com.example.tz.dao.entities.LimitEntityPk;
import com.example.tz.dao.entities.TransactionEntity;
import com.example.tz.dao.repos.CurrencyRepository;
import com.example.tz.dao.repos.LimitRepository;
import com.example.tz.dao.repos.TransactionRepository;
import com.example.tz.web.LimitExceededTransactionDto;
import com.example.tz.web.SaveTransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;

    private final LimitRepository limitRepository;

    private final CurrencyRepository currencyRepository;

    @Override
    @Transactional
    public void createTransaction(SaveTransactionDto saveTransactionDto) {
        LimitEntityPk limitEntityPk = new LimitEntityPk(saveTransactionDto.getAccountFrom(), saveTransactionDto.getExpenseCategory());
        LimitEntity limitEntity = limitRepository.getLimitEntityByPk(limitEntityPk);
        double transactionInUSD = saveTransactionDto.getSum() / currencyRepository.getCurrencyEntityByCurrencyType(saveTransactionDto.getCurrencyShortname()).getClose();
        boolean limitExceeded = limitEntity.getLimitRemains() - transactionInUSD < 0;
        limitRepository.changeLimitRemainder(limitEntityPk, transactionInUSD);

        transactionRepository.save(
                new TransactionEntity(
                        null,
                        saveTransactionDto.getAccountFrom(),
                        saveTransactionDto.getAccountTo(),
                        saveTransactionDto.getCurrencyShortname(),
                        saveTransactionDto.getSum(),
                        saveTransactionDto.getExpenseCategory(),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ssXXX", Locale.getDefault()).format(new Date()),
                        limitExceeded
                )
        );
    }

    @Override
    public List<LimitExceededTransactionDto> getLimitExceededTransactions(String bankAccount) {
        return transactionRepository.getLimitExceededTransactions(bankAccount);
    }
}
