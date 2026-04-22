package com.swyp3.skin.recommendation.ux;

import java.util.Map;

public record IngredientMeta(
        String name,
        String description
) {
    public static IngredientMeta get(IngredientType type) {
        return META.get(type);
    }

    private static final Map<IngredientType, IngredientMeta> META = Map.ofEntries(

            Map.entry(IngredientType.HYALURONIC_ACID,
                    new IngredientMeta("히알루론산", "피부에 자연적으로 존재하는 수분 보유 성분이에요. 오일이 전혀 없어서 어떤 피부 타입에도 자극 없이 사용할 수 있고, 세안 직후 토너나 세럼 단계에서 가장 먼저 쓰면 효과가 좋아요.")),

            Map.entry(IngredientType.GLYCERIN,
                    new IngredientMeta("글리세린", "공기 중 수분을 끌어당겨 피부에 붙잡아두는 기초 보습 성분이에요. 히알루론산보다 분자가 작아 빠르게 흡수되고 가볍게 느껴져요. 단독보다는 히알루론산, 판테놀 같은 다른 수분 성분과 함께 쓸 때 시너지가 나요.")),

            Map.entry(IngredientType.BETA_GLUCAN,
                    new IngredientMeta("베타글루칸", "귀리나 효모에서 추출한 성분으로, 히알루론산보다 더 깊은 층까지 수분을 공급해줘요. 피부 면역 기능을 강화하고 손상된 피부 회복을 도와줘요. 자극이 거의 없어서 예민한 피부나 민감한 시기에도 안전하게 사용할 수 있어요.")),

            Map.entry(IngredientType.CERAMIDE,
                    new IngredientMeta("세라마이드", "피부 장벽을 구성하는 핵심 지질 성분이에요. 세라마이드가 부족하면 수분이 쉽게 빠져나가고 외부 자극에 민감해져요. 콜레스테롤·지방산과 함께 쓰면 장벽 복구 효과가 배가 되고, 크림 단계에서 수분을 잠그는 마무리 역할을 해요.")),

            Map.entry(IngredientType.CERAMIDE_LIGHT,
                    new IngredientMeta("세라마이드(가벼운)", "세라마이드의 기능은 동일하지만 젤·에멀전 형태로 만들어져 훨씬 가볍게 발려요. 오일리한 피부나 번들거림이 걱정될 때도 유분 없이 장벽을 복구할 수 있어요. 피지가 많으면서 장벽도 챙겨야 하는 복합적인 피부에 적합해요.")),

            Map.entry(IngredientType.PANTHENOL,
                    new IngredientMeta("판테놀", "비타민 B5의 전구체로, 피부에서 비타민 B5로 전환되어 세포 재생을 도와요. 자극받거나 손상된 피부를 빠르게 진정시키고, 수분 공급과 보습까지 동시에 해줘요. 자극이 거의 없어서 예민한 피부, 트러블 난 피부, 각질 케어 후 피부 모두에 쓸 수 있어요.")),

            Map.entry(IngredientType.CENTELLA,
                    new IngredientMeta("센텔라", "센텔라아시아티카에서 추출한 성분으로, 마데카소사이드 등 활성 성분이 피부 염증을 빠르게 가라앉혀요. 트러블, 홍조, 자극받은 피부 모두에 효과적이에요. 피부 재생을 도와 트러블 자국이 남는 것도 예방해줘요.")),

            Map.entry(IngredientType.MADECASSOSIDE,
                    new IngredientMeta("마데카소사이드", "센텔라의 핵심 활성 성분이에요. 피부 콜라겐 합성을 촉진하고 장벽 회복을 도와줘요. 센텔라 전체 추출물보다 더 정제된 형태라 자극이 적고 효과가 빠르게 나타날 수 있어요. 예민하거나 장벽이 약해진 피부에 특히 효과적이에요.")),

            Map.entry(IngredientType.NIACINAMIDE,
                    new IngredientMeta("나이아신아마이드", "비타민 B3 유도체로, 피지 분비 억제·미백·장벽 보조·트러블 예방까지 다양한 효과를 가진 다기능 성분이에요. 다른 성분과 충돌이 거의 없어서 어떤 루틴에도 쉽게 추가할 수 있어요. 10% 농도는 피지 조절과 미백에, 5% 이하는 진정과 장벽 보조에 효과적이에요.")),

            Map.entry(IngredientType.NIACINAMIDE_LOW,
                    new IngredientMeta("나이아신아마이드(저농도)", "나이아신아마이드를 2~5% 낮은 농도로 배합한 제품이에요. 고농도보다 자극이 적어서 예민한 피부, 처음 사용하는 피부에 더 안전해요. 피지 조절보다는 진정·장벽 보조·톤 케어 효과를 부드럽게 경험할 수 있어요.")),

            Map.entry(IngredientType.ZINC,
                    new IngredientMeta("징크", "아연 성분으로, 피지선 활동을 억제하고 항염 효과로 트러블을 완화해줘요. 나이아신아마이드와 함께 쓰면 피지 조절 시너지가 나요. 선크림의 자외선 차단 성분으로도 활용되며, 예민한 피부에도 안전해요.")),

            Map.entry(IngredientType.CLAY,
                    new IngredientMeta("클레이", "카올린·벤토나이트 등 점토 성분으로, 모공 속 피지와 노폐물을 흡착해 제거해줘요. 주로 마스크팩 형태로 사용하며 딥클렌징 효과가 뛰어나요. 너무 자주 쓰면 피부가 건조해질 수 있으니 주 1~2회가 적당해요.")),

            Map.entry(IngredientType.AHA_GLYCOLIC_ACID,
                    new IngredientMeta("AHA(글리콜릭애시드)", "수용성 산 성분으로, 피부 표면의 죽은 각질 세포를 녹여 탈락시켜요. 피부 결을 정돈하고 미백 성분의 흡수를 높여줘요. 레티놀과 같은 날 사용하면 자극이 강해질 수 있고, 사용 후 선크림은 반드시 발라야 해요.")),

            Map.entry(IngredientType.AHA_LOW,
                    new IngredientMeta("AHA(저농도)", "AHA(글리콜릭애시드)와 동일한 작용을 하지만 낮은 농도로 배합되어 자극이 적어요. 각질 케어를 처음 시작하거나 예민한 편인 피부에 적합해요. 주 2~3회 저녁에 사용하고, 다음 날 아침 선크림을 꼭 발라야 해요.")),

            Map.entry(IngredientType.BHA_SALICYLIC_ACID,
                    new IngredientMeta("BHA(살리실산)", "지용성 산 성분으로, AHA와 달리 모공 속까지 들어가 피지와 각질을 동시에 제거해요. 여드름·블랙헤드·화이트헤드에 특히 효과적이에요. 모공 속 노폐물 제거에 탁월하고, 저농도(0.5~2%)는 일상적으로 사용 가능해요.")),

            Map.entry(IngredientType.SALICYLIC_ACID,
                    new IngredientMeta("살리실산", "BHA의 대표 성분이에요. 지용성이라 모공 속까지 들어가 피지와 각질을 동시에 제거해요. 여드름과 블랙헤드에 효과적이고, 항염 효과로 트러블 부위의 염증도 가라앉혀줘요.")),

            Map.entry(IngredientType.SALICYLIC_ACID_LOW,
                    new IngredientMeta("살리실산(저농도)", "살리실산을 낮은 농도로 배합해 자극을 줄인 제품이에요. 장벽이 약하거나 예민한 피부에도 비교적 안전하게 모공과 트러블을 케어할 수 있어요. 처음 BHA를 써보는 경우 저농도부터 시작하는 게 좋아요.")),

            Map.entry(IngredientType.PHA,
                    new IngredientMeta("PHA", "AHA보다 분자가 커서 피부 깊이 침투하지 않아 자극이 훨씬 적어요. 예민한 피부, 장벽이 약해진 피부에도 안전하게 각질 케어를 할 수 있는 유일한 산 성분이에요. 보습 효과도 함께 있어서 각질을 제거하면서 수분도 챙길 수 있어요.")),

            Map.entry(IngredientType.VITAMIN_C,
                    new IngredientMeta("비타민C", "멜라닌 생성을 억제하고 이미 생긴 잡티를 옅게 만들어줘요. 항산화 효과로 자외선 손상으로부터 피부를 보호해요. 산화되기 쉬운 성분이라 보관에 주의가 필요하고, 아침에 바른 뒤 선크림을 덧바르면 효과가 더 좋아요.")),

            Map.entry(IngredientType.VITAMIN_C_STABLE,
                    new IngredientMeta("비타민C(안정화)", "비타민C를 산화에 강한 형태로 안정화시킨 성분이에요. 일반 비타민C보다 공기·빛에 덜 민감해서 효과가 더 오래 유지돼요. 자극도 상대적으로 적어서 비타민C를 처음 시작하거나 예민한 피부에 더 적합해요.")),

            Map.entry(IngredientType.ARBUTIN,
                    new IngredientMeta("알부틴", "멜라닌 생성 효소를 억제해 색소 침착을 예방하고 기존 잡티를 옅게 만들어요. 비타민C보다 자극이 적어서 예민한 피부, 장벽이 약한 피부에도 안전하게 사용할 수 있어요. 꾸준히 쓰면 피부톤이 서서히 균일해져요.")),

            Map.entry(IngredientType.PEPTIDE,
                    new IngredientMeta("펩타이드", "아미노산이 연결된 짧은 단백질 조각으로, 피부에 콜라겐 생성 신호를 보내 탄력을 개선해요. 레티놀보다 자극이 훨씬 적어서 예민한 피부나 레티놀을 쓰기 어려운 피부에도 탄력 케어를 할 수 있어요. 아침·저녁 모두 사용할 수 있어요.")),

            Map.entry(IngredientType.RETINOL_LOW,
                    new IngredientMeta("레티놀(저농도)", "비타민 A 유도체로, 세포 재생을 촉진해 탄력 개선·주름 완화·각질 정리·트러블 예방까지 다양한 효과를 가져요. 처음엔 자극이 있을 수 있어서 낮은 농도(0.025~0.1%)부터 주 2~3회 저녁에 쓰는 게 중요해요. 임산부는 사용을 피해야 해요.")),

            Map.entry(IngredientType.AZELAIC_ACID,
                    new IngredientMeta("아젤라익산", "트러블의 원인균을 억제하고 염증을 가라앉혀요. 동시에 멜라닌 생성을 억제해서 트러블 자국과 색소 침착도 함께 케어해줘요. 자극이 적어서 예민한 피부, 임산부도 비교적 안전하게 사용할 수 있는 트러블 성분이에요."))
    );
}
