package com.dispatch.application.service;

import com.dispatch.application.entities.Quote;
import com.dispatch.application.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    QuoteRepository quoteRepository;

    @Override
    public Quote getQuoteById(int quoteId) {
        return quoteRepository.findById(quoteId).get();
    }

    @Override
    public void save(Quote quote) {
        quoteRepository.saveAndFlush(quote);
    }

    @Override
    public List<Quote> quoteList() {
        return quoteRepository.findAll();
    }
}
