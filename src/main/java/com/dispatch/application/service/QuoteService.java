package com.dispatch.application.service;

import com.dispatch.application.entities.Quote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuoteService {

     Quote getQuoteById(int quoteId);
     void save(Quote quote);
     List<Quote> quoteList();
}
