package com.example.BookStore;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BookValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors e) {
//        ValidationUtils.rejectIfEmpty(e, "title", "title.empty");
//        ValidationUtils.rejectIfEmpty(e, "author", "author.empty");
//        ValidationUtils.rejectIfEmpty(e, "price", "price.NegativeOrZero");
//        Book book = (Book)o;
//        if (book.getTitle()==null || book.getTitle().equals("")){
//            e.rejectValue("title", "title.empty");
//        }
//        if (book.getAuthor()==null || book.getAuthor().equals("")){
//            e.rejectValue("author", "author.empty");
//        }
//        if (book.getPrice()==null || book.getPrice()<=0){
//            e.rejectValue("price", "price.empty");
//        }


    }


}
