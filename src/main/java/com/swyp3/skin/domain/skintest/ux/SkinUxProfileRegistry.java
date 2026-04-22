package com.swyp3.skin.domain.skintest.ux;

import com.swyp3.skin.domain.common.enums.IngredientGroup;

import java.util.List;
import java.util.Map;

public class SkinUxProfileRegistry {
    public SkinUxProfileRegistry() {
    }

    public static final Map<SkinUxKey, SkinUxProfile> PROFILES = Map.ofEntries(

            // 유형 01 — HYDRATION
            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.BARRIER,
                    "촉촉한 수분 결핍형",
                    "장벽까지 같이 약해진 상태예요",
                    List.of("세라마이드", "나이아신아마이드"),
                    "장벽을 보조하면서 수분이 새어나가지 않게 도와줘요.",
                    List.of("고농도 알코올", "강한 계면활성제")
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.SEBUM_CONTROL,
                    "촉촉한 수분 결핍형",
                    "속은 건조한데 겉은 번들거려요",
                    List.of("히알루론산", "나이아신아마이드"),
                    "오일프리 성분으로 수분만 채워 유분 없이 속건조를 해결해요.",
                    List.of("과한 오일 성분", "실리콘 고함량")
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.ACNE,
                    "건조한데 트러블도 나는 복합형",
                    "건조한데 트러블도 같이 나요",
                    List.of("나이아신아마이드", "판테놀"),
                    "트러블을 자극하지 않으면서 수분을 채워줘요.",
                    List.of("BHA 고농도", "벤조일퍼옥사이드")
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.SOOTHING,
                    "촉촉한 수분 결핍형",
                    "건조하면서 예민하기까지 해요",
                    List.of("판테놀", "히알루론산"),
                    "예민해진 피부를 진정시키면서 동시에 수분을 채워줘요.",
                    List.of("향료", "알코올", "멘톨")
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.BRIGHTENING,
                    "촉촉한 수분 결핍형",
                    "건조하면서 톤도 흐려지고 있어요",
                    List.of("비타민C", "히알루론산"),
                    "수분을 채우면서 칙칙한 톤을 함께 케어해요.",
                    List.of("고농도 비타민C", "알코올")
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.TURNOVER,
                    "촉촉한 수분 결핍형",
                    "건조한데 각질까지 올라와요",
                    List.of("저농도 AHA", "히알루론산"),
                    "각질을 부드럽게 제거하면서 수분을 공급해요.",
                    List.of("BHA 고농도", "물리적 스크럽")
            ),

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.ANTI_AGING,
                    "촉촉한 수분 결핍형",
                    "건조하면서 탄력도 신경 쓰여요",
                    List.of("펩타이드", "히알루론산"),
                    "수분과 탄력을 동시에 케어해요.",
                    List.of("고농도 레티놀", "알코올")
            ),

            // 유형 02 - BARRIER
            entry(
                    IngredientGroup.BARRIER, IngredientGroup.HYDRATION,
                    "예민한 장벽 위기형",
                    "장벽이 약해지면서 속도 건조해요",
                    List.of("세라마이드", "히알루론산"),
                    "장벽을 복구하면서 수분도 함께 채워줘요.",
                    List.of("알코올", "강한 산성 성분")
            ),

            entry(
                    IngredientGroup.BARRIER, IngredientGroup.SOOTHING,
                    "예민한 장벽 위기형",
                    "작은 자극에도 크게 반응해요",
                    List.of("마데카소사이드", "세라마이드"),
                    "예민한 피부를 진정시키면서 장벽을 회복해요.",
                    List.of("향료", "알코올", "에센셜오일")
            ),

            entry(
                    IngredientGroup.BARRIER, IngredientGroup.ACNE,
                    "예민한 장벽 위기형",
                    "장벽도 약한데 트러블도 나요",
                    List.of("판테놀", "세라마이드"),
                    "장벽을 먼저 살리면 트러블도 줄어들어요.",
                    List.of("BHA 고농도", "벤조일퍼옥사이드", "레티놀")
            ),

            entry(
                    IngredientGroup.BARRIER, IngredientGroup.SEBUM_CONTROL,
                    "예민한 장벽 위기형",
                    "장벽은 약한데 유분은 많아요",
                    List.of("나이아신아마이드", "세라마이드"),
                    "피지를 조절하면서 장벽을 복구해요.",
                    List.of("알코올 함유 토너", "과한 클레이")
            ),

            entry(
                    IngredientGroup.BARRIER, IngredientGroup.BRIGHTENING,
                    "예민한 장벽 위기형",
                    "장벽이 약하면서 톤도 고르지 않아요",
                    List.of("알부틴", "판테놀"),
                    "자극 없는 미백 성분으로 톤을 케어해요.",
                    List.of("고농도 비타민C", "AHA/BHA 고농도")
            ),

            entry(
                    IngredientGroup.BARRIER, IngredientGroup.TURNOVER,
                    "예민한 장벽 위기형",
                    "장벽이 약해서 각질 관리가 어려워요",
                    List.of("PHA", "세라마이드"),
                    "자극 없이 각질을 케어해요.",
                    List.of("AHA 고농도", "BHA", "물리적 스크럽")
            ),

            entry(
                    IngredientGroup.BARRIER, IngredientGroup.ANTI_AGING,
                    "예민한 장벽 위기형",
                    "장벽도 약한데 탄력도 걱정돼요",
                    List.of("펩타이드", "세라마이드"),
                    "레티놀 대신 펩타이드로 탄력을 케어해요.",
                    List.of("레티놀", "고농도 산 성분")
            ),

            // 유형 03 ACNE
            entry(
                    IngredientGroup.ACNE, IngredientGroup.HYDRATION,
                    "열정적인 피지 활동형",
                    "트러블이 나는데 속은 당기기도 해요",
                    List.of("나이아신아마이드", "센텔라"),
                    "트러블 케어와 수분 공급을 동시에 해줘요.",
                    List.of("과한 오일", "코코넛오일")
            ),

            entry(
                    IngredientGroup.ACNE, IngredientGroup.BARRIER,
                    "열정적인 피지 활동형",
                    "트러블 때문에 장벽도 약해졌어요",
                    List.of("판테놀", "살리실산"),
                    "장벽 보호와 트러블 케어를 동시에 진행해요.",
                    List.of("벤조일퍼옥사이드", "알코올")
            ),

            entry(
                    IngredientGroup.ACNE, IngredientGroup.SOOTHING,
                    "열정적인 피지 활동형",
                    "트러블도 있고 예민하기까지 해요",
                    List.of("센텔라", "살리실산"),
                    "염증 완화와 진정을 동시에 진행해요.",
                    List.of("향료", "고농도 산", "멘톨")
            ),

            entry(
                    IngredientGroup.ACNE, IngredientGroup.SEBUM_CONTROL,
                    "열정적인 피지 활동형",
                    "피지가 트러블을 계속 만들어요",
                    List.of("살리실산", "나이아신아마이드"),
                    "피지 조절이 트러블을 줄여줘요.",
                    List.of("코코넛오일", "라놀린")
            ),

            entry(
                    IngredientGroup.ACNE, IngredientGroup.BRIGHTENING,
                    "열정적인 피지 활동형",
                    "트러블 자국까지 남아요",
                    List.of("나이아신아마이드", "아젤라익산"),
                    "트러블과 색소를 동시에 케어해요.",
                    List.of("고농도 비타민C", "스크럽")
            ),

            entry(
                    IngredientGroup.ACNE, IngredientGroup.TURNOVER,
                    "열정적인 피지 활동형",
                    "각질이 쌓여 트러블이 심해요",
                    List.of("BHA", "아젤라익산"),
                    "모공 속 각질 제거로 트러블 예방",
                    List.of("AHA 고농도", "스크럽")
            ),

            entry(
                    IngredientGroup.ACNE, IngredientGroup.ANTI_AGING,
                    "열정적인 피지 활동형",
                    "트러블 관리에 탄력도 필요해요",
                    List.of("나이아신아마이드", "펩타이드"),
                    "저자극으로 탄력 케어 병행",
                    List.of("고농도 레티놀")
            ),

            // 유형 04 - SEBUM_CONTROL
            entry(
                    IngredientGroup.SEBUM_CONTROL, IngredientGroup.HYDRATION,
                    "번들번들 피지 과잉형",
                    "번들거리는데 속은 건조하기도 해요",
                    List.of("나이아신아마이드", "히알루론산"),
                    "수분을 채우면서 피지를 조절해요.",
                    List.of("과한 오일", "실리콘 고함량")
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL, IngredientGroup.BARRIER,
                    "번들번들 피지 과잉형",
                    "피지가 많은데 장벽도 약해요",
                    List.of("나이아신아마이드", "세라마이드"),
                    "피지 조절과 장벽 보호를 동시에 해요.",
                    List.of("알코올", "과한 오일")
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL, IngredientGroup.SOOTHING,
                    "번들번들 피지 과잉형",
                    "번들거리면서 예민하기도 해요",
                    List.of("나이아신아마이드", "센텔라"),
                    "피지 조절과 진정을 동시에 해줘요.",
                    List.of("향료", "알코올", "에센셜오일")
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL, IngredientGroup.ACNE,
                    "번들번들 피지 과잉형",
                    "피지가 많아서 트러블도 잦아요",
                    List.of("살리실산", "나이아신아마이드"),
                    "피지 조절이 트러블까지 함께 잡아줘요.",
                    List.of("코코넛오일", "라놀린")
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL, IngredientGroup.BRIGHTENING,
                    "번들번들 피지 과잉형",
                    "번들거리는데 톤도 아쉬워요",
                    List.of("나이아신아마이드", "비타민C"),
                    "피지 조절과 톤 개선을 동시에 해요.",
                    List.of("오일 베이스 미백")
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL, IngredientGroup.TURNOVER,
                    "번들번들 피지 과잉형",
                    "피지에 각질까지 겹쳐서 복잡해요",
                    List.of("BHA", "나이아신아마이드"),
                    "각질과 피지를 동시에 케어해요.",
                    List.of("AHA 고농도", "스크럽")
            ),

            entry(
                    IngredientGroup.SEBUM_CONTROL, IngredientGroup.ANTI_AGING,
                    "번들번들 피지 과잉형",
                    "피지 조절하면서 탄력도 챙기고 싶어요",
                    List.of("나이아신아마이드", "펩타이드"),
                    "피지를 먼저 잡고 탄력을 보조해요.",
                    List.of("오일리한 크림")
            ),

            // 유형 06 - BRIGHTENING
            entry(
                    IngredientGroup.BRIGHTENING, IngredientGroup.HYDRATION,
                    "칙칙한 색소 고민형",
                    "톤이 흐리면서 속도 건조해요",
                    List.of("비타민C", "히알루론산"),
                    "수분을 채우면서 톤을 밝혀줘요.",
                    List.of("고농도 비타민C", "알코올")
            ),

            entry(
                    IngredientGroup.BRIGHTENING, IngredientGroup.BARRIER,
                    "칙칙한 색소 고민형",
                    "톤이 고르지 않으면서 예민해요",
                    List.of("알부틴", "나이아신아마이드"),
                    "저자극으로 톤을 케어해요.",
                    List.of("고농도 비타민C")
            ),

            entry(
                    IngredientGroup.BRIGHTENING, IngredientGroup.ACNE,
                    "칙칙한 색소 고민형",
                    "트러블 자국이 남아요",
                    List.of("나이아신아마이드", "알부틴"),
                    "자국과 색소를 동시에 케어해요.",
                    List.of("고농도 산")
            ),

            entry(
                    IngredientGroup.BRIGHTENING, IngredientGroup.SEBUM_CONTROL,
                    "칙칙한 색소 고민형",
                    "번들거리면서 톤도 칙칙해요",
                    List.of("나이아신아마이드", "비타민C"),
                    "피지 조절과 톤 개선을 동시에 해요.",
                    List.of("오일 베이스 미백")
            ),

            entry(
                    IngredientGroup.BRIGHTENING, IngredientGroup.TURNOVER,
                    "칙칙한 색소 고민형",
                    "각질 때문에 더 어두워 보여요",
                    List.of("AHA", "비타민C"),
                    "각질 제거로 톤 개선",
                    List.of("스크럽")
            ),

            entry(
                    IngredientGroup.BRIGHTENING, IngredientGroup.ANTI_AGING,
                    "칙칙한 색소 고민형",
                    "색소와 탄력을 같이 챙겨야 해요",
                    List.of("비타민C", "레티놀"),
                    "톤과 탄력 동시 케어",
                    List.of("고농도 레티놀")
            ),

            entry(
                    IngredientGroup.BRIGHTENING, IngredientGroup.SOOTHING,
                    "칙칙한 색소 고민형",
                    "예민해서 톤 케어가 어려워요",
                    List.of("알부틴", "판테놀"),
                    "저자극 미백",
                    List.of("고농도 비타민C")
            ),

            // 유형 07 - ANTI_AGING
            entry(
                    IngredientGroup.ANTI_AGING, IngredientGroup.HYDRATION,
                    "탄력 저하형",
                    "탄력과 건조가 함께 와요",
                    List.of("펩타이드", "히알루론산"),
                    "수분과 탄력 동시 케어",
                    List.of("알코올")
            ),

            entry(
                    IngredientGroup.ANTI_AGING, IngredientGroup.BARRIER,
                    "탄력 저하형",
                    "탄력과 장벽이 모두 약해요",
                    List.of("펩타이드", "세라마이드"),
                    "장벽 복구 + 탄력",
                    List.of("레티놀")
            ),

            entry(
                    IngredientGroup.ANTI_AGING, IngredientGroup.SOOTHING,
                    "탄력 저하형",
                    "예민하면서 탄력도 떨어졌어요",
                    List.of("펩타이드", "판테놀"),
                    "자극 없이 탄력 케어",
                    List.of("레티놀")
            ),

            entry(
                    IngredientGroup.ANTI_AGING, IngredientGroup.ACNE,
                    "탄력 저하형",
                    "탄력도 걱정인데 트러블도 있어요",
                    List.of("레티놀", "나이아신아마이드"),
                    "두 가지 동시 케어",
                    List.of("고농도 BHA")
            ),

            entry(
                    IngredientGroup.ANTI_AGING, IngredientGroup.SEBUM_CONTROL,
                    "탄력 저하형",
                    "탄력 + 피지 문제",
                    List.of("레티놀", "나이아신아마이드"),
                    "모공과 탄력 동시에 케어",
                    List.of("오일")
            ),

            entry(
                    IngredientGroup.ANTI_AGING, IngredientGroup.BRIGHTENING,
                    "탄력 저하형",
                    "탄력과 색소 동시 고민",
                    List.of("레티놀", "비타민C"),
                    "톤 + 탄력",
                    List.of("동시 사용")
            ),

            entry(
                    IngredientGroup.ANTI_AGING, IngredientGroup.TURNOVER,
                    "탄력 저하형",
                    "탄력 + 각질 문제",
                    List.of("레티놀", "AHA"),
                    "재생 촉진",
                    List.of("동시 사용")
            ),

            // 유형 08 - SOOTHING
            entry(
                    IngredientGroup.SOOTHING, IngredientGroup.HYDRATION,
                    "홍조 민감형",
                    "예민하면서 건조해요",
                    List.of("판테놀", "히알루론산"),
                    "진정 + 수분",
                    List.of("향료")
            ),

            entry(
                    IngredientGroup.SOOTHING, IngredientGroup.BARRIER,
                    "홍조 민감형",
                    "장벽도 무너졌어요",
                    List.of("센텔라", "세라마이드"),
                    "진정 + 장벽 복구",
                    List.of("알코올")
            ),

            entry(
                    IngredientGroup.SOOTHING, IngredientGroup.ACNE,
                    "홍조 민감형",
                    "트러블도 함께 있어요",
                    List.of("센텔라", "나이아신아마이드"),
                    "자극 없이 트러블 케어",
                    List.of("BHA 고농도")
            ),

            entry(
                    IngredientGroup.SOOTHING, IngredientGroup.SEBUM_CONTROL,
                    "홍조 민감형",
                    "예민하면서 번들거려요",
                    List.of("나이아신아마이드", "센텔라"),
                    "피지 + 진정",
                    List.of("알코올")
            ),

            entry(
                    IngredientGroup.SOOTHING, IngredientGroup.BRIGHTENING,
                    "홍조 민감형",
                    "톤 케어가 어려워요",
                    List.of("알부틴", "판테놀"),
                    "저자극 미백",
                    List.of("고농도 비타민C")
            ),

            entry(
                    IngredientGroup.SOOTHING, IngredientGroup.TURNOVER,
                    "홍조 민감형",
                    "각질 관리가 어려워요",
                    List.of("PHA", "판테놀"),
                    "저자극 각질 케어",
                    List.of("AHA", "BHA")
            ),

            entry(
                    IngredientGroup.SOOTHING, IngredientGroup.ANTI_AGING,
                    "홍조 민감형",
                    "탄력도 신경 쓰여요",
                    List.of("펩타이드", "판테놀"),
                    "자극 없이 탄력 케어",
                    List.of("레티놀")
            )
    );
    private static Map.Entry<SkinUxKey, SkinUxProfile> entry(
            IngredientGroup top1,
            IngredientGroup top2,
            String typeName,
            String subtitle,
            List<String> ingredients,
            String reason,
            List<String> avoid
    ) {
        return Map.entry(
                SkinUxKey.of(top1, top2),
                new SkinUxProfile(
                        typeName,
                        subtitle,
                        ingredients,
                        reason,
                        avoid,
                        false
                )
        );
    }

}
