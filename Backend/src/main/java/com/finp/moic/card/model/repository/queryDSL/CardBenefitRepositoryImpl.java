package com.finp.moic.card.model.repository.queryDSL;

import com.finp.moic.card.model.dto.response.CardBenefitResponseDTO;
import com.finp.moic.card.model.dto.response.QCardBenefitResponseDTO;
import com.finp.moic.card.model.entity.CardBenefit;
import com.finp.moic.card.model.entity.QCard;
import com.finp.moic.card.model.entity.QCardBenefit;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardBenefitRepositoryImpl implements CardBenefitRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Autowired
    public CardBenefitRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    /**
     * TO DO :: 필요한 칼럼만 받고, DTO로 리턴하도록 수정
     **/

    public Boolean exist(String cardName){
        QCardBenefit cardBenefit=QCardBenefit.cardBenefit;

        Integer fetchOne = queryFactory
                .selectOne()
                .from(cardBenefit)
                .where(cardBenefit.card.name.eq(cardName))
                .fetchFirst();

        return fetchOne != null;
    }

    @Override
    public List<CardBenefitResponseDTO> findByCardName(String cardName) {
        QCardBenefit cardBenefit=QCardBenefit.cardBenefit;

        return queryFactory
                .select(
                        new QCardBenefitResponseDTO(
                                cardBenefit.category,
                                cardBenefit.shopName,
                                cardBenefit.content,
                                cardBenefit.discount,
                                cardBenefit.point,
                                cardBenefit.cashback
                        )
                )
                .from(cardBenefit)
                .where(cardBenefit.card.name.eq(cardName))
                .fetch();
    }


    @Override
    public List<CardBenefit> findAllByShopName(String shopName) {

        QCardBenefit cardBenefit=QCardBenefit.cardBenefit;

        return queryFactory
                .select(cardBenefit)
                .from(cardBenefit)
                .where(cardBenefit.shopName.eq(shopName))
                .fetch();
    }
}
