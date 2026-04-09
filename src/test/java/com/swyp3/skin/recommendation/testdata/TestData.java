package com.swyp3.skin.recommendation.testdata;

import com.swyp3.skin.recommendation.model.enums.Concern;
import com.swyp3.skin.recommendation.model.enums.SkinState;
import com.swyp3.skin.recommendation.model.enums.SkinType;
import com.swyp3.skin.recommendation.model.test.TestCase;

import java.util.List;
import java.util.Map;

public class TestData {
    public static List<TestCase> getTestCases() {
        return testCases;
    }
    static List<TestCase> testCases = List.of(

            // U01
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 25,
                            SkinState.SEBUM, 85,
                            SkinState.ACNE, 85,
                            SkinState.SENSITIVITY, 55,
                            SkinState.PIGMENTATION, 55,
                            SkinState.AGING, 25
                    ),
                    List.of(Concern.ACNE, Concern.SEBUM),
                    SkinType.OILY
            ),

            // U02
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 85,
                            SkinState.SEBUM, 25,
                            SkinState.ACNE, 25,
                            SkinState.SENSITIVITY, 85,
                            SkinState.PIGMENTATION, 40,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.DRY, Concern.SENSITIVE),
                    SkinType.SENSITIVE
            ),

            // U03
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 60,
                            SkinState.SEBUM, 70,
                            SkinState.ACNE, 40,
                            SkinState.SENSITIVITY, 40,
                            SkinState.PIGMENTATION, 55,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.SEBUM, Concern.DRY),
                    SkinType.COMBINATION
            ),

            // U04
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 70,
                            SkinState.SEBUM, 32,
                            SkinState.ACNE, 25,
                            SkinState.SENSITIVITY, 40,
                            SkinState.PIGMENTATION, 55,
                            SkinState.AGING, 85
                    ),
                    List.of(Concern.AGING, Concern.DRY),
                    SkinType.DRY
            ),

            // U05
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 40,
                            SkinState.SEBUM, 40,
                            SkinState.ACNE, 25,
                            SkinState.SENSITIVITY, 40,
                            SkinState.PIGMENTATION, 85,
                            SkinState.AGING, 55
                    ),
                    List.of(Concern.PIGMENTATION, Concern.AGING),
                    SkinType.DRY
            ),

            // U06
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 45,
                            SkinState.SEBUM, 62,
                            SkinState.ACNE, 47,
                            SkinState.SENSITIVITY, 55,
                            SkinState.PIGMENTATION, 77,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.PIGMENTATION, Concern.SEBUM),
                    SkinType.COMBINATION
            ),

            // U07
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 75,
                            SkinState.SEBUM, 25,
                            SkinState.ACNE, 25,
                            SkinState.SENSITIVITY, 47,
                            SkinState.PIGMENTATION, 77,
                            SkinState.AGING, 77
                    ),
                    List.of(Concern.AGING, Concern.PIGMENTATION),
                    SkinType.DRY
            ),

            // U08
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 55,
                            SkinState.SEBUM, 40,
                            SkinState.ACNE, 70,
                            SkinState.SENSITIVITY, 85,
                            SkinState.PIGMENTATION, 40,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.SENSITIVE, Concern.ACNE),
                    SkinType.SENSITIVE
            ),

            // U09
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 55,
                            SkinState.SEBUM, 55,
                            SkinState.ACNE, 55,
                            SkinState.SENSITIVITY, 55,
                            SkinState.PIGMENTATION, 55,
                            SkinState.AGING, 55
                    ),
                    List.of(Concern.DRY, Concern.SEBUM),
                    SkinType.COMBINATION
            ),

            // U10
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 30,
                            SkinState.SEBUM, 85,
                            SkinState.ACNE, 32,
                            SkinState.SENSITIVITY, 40,
                            SkinState.PIGMENTATION, 55,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.SEBUM, Concern.PORE),
                    SkinType.OILY
            ),

            // U11
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 80,
                            SkinState.SEBUM, 32,
                            SkinState.ACNE, 77,
                            SkinState.SENSITIVITY, 55,
                            SkinState.PIGMENTATION, 55,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.DRY, Concern.ACNE),
                    SkinType.DRY
            ),

            // U12
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 40,
                            SkinState.SEBUM, 40,
                            SkinState.ACNE, 25,
                            SkinState.SENSITIVITY, 32,
                            SkinState.PIGMENTATION, 40,
                            SkinState.AGING, 85
                    ),
                    List.of(Concern.AGING, Concern.PIGMENTATION),
                    SkinType.DRY
            ),

            // U13
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 50,
                            SkinState.SEBUM, 62,
                            SkinState.ACNE, 40,
                            SkinState.SENSITIVITY, 77,
                            SkinState.PIGMENTATION, 47,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.SENSITIVE, Concern.SEBUM),
                    SkinType.COMBINATION
            ),

            // U14
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 40,
                            SkinState.SEBUM, 77,
                            SkinState.ACNE, 55,
                            SkinState.SENSITIVITY, 40,
                            SkinState.PIGMENTATION, 77,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.SEBUM, Concern.PIGMENTATION),
                    SkinType.OILY
            ),

            // U15
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 80,
                            SkinState.SEBUM, 25,
                            SkinState.ACNE, 25,
                            SkinState.SENSITIVITY, 40,
                            SkinState.PIGMENTATION, 40,
                            SkinState.AGING, 55
                    ),
                    List.of(Concern.DRY, Concern.AGING),
                    SkinType.DRY
            ),

            // U16
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 35,
                            SkinState.SEBUM, 77,
                            SkinState.ACNE, 77,
                            SkinState.SENSITIVITY, 55,
                            SkinState.PIGMENTATION, 70,
                            SkinState.AGING, 32
                    ),
                    List.of(Concern.ACNE, Concern.PIGMENTATION),
                    SkinType.OILY
            ),

            // U17
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 50,
                            SkinState.SEBUM, 32,
                            SkinState.ACNE, 25,
                            SkinState.SENSITIVITY, 77,
                            SkinState.PIGMENTATION, 55,
                            SkinState.AGING, 77
                    ),
                    List.of(Concern.AGING, Concern.SENSITIVE),
                    SkinType.SENSITIVE
            ),

            // U18
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 30,
                            SkinState.SEBUM, 85,
                            SkinState.ACNE, 47,
                            SkinState.SENSITIVITY, 40,
                            SkinState.PIGMENTATION, 47,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.SEBUM, Concern.PORE),
                    SkinType.OILY
            ),

            // U19
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 85,
                            SkinState.SEBUM, 70,
                            SkinState.ACNE, 70,
                            SkinState.SENSITIVITY, 85,
                            SkinState.PIGMENTATION, 70,
                            SkinState.AGING, 70
                    ),
                    List.of(Concern.SENSITIVE, Concern.DRY),
                    SkinType.SENSITIVE
            ),

            // U20
            new TestCase(
                    Map.of(
                            SkinState.DRYNESS, 30,
                            SkinState.SEBUM, 32,
                            SkinState.ACNE, 25,
                            SkinState.SENSITIVITY, 25,
                            SkinState.PIGMENTATION, 32,
                            SkinState.AGING, 40
                    ),
                    List.of(Concern.AGING, Concern.DRY),
                    SkinType.DRY
            )
    );
//    static List<TestCase> testCases = List.of(
//            // U01
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         85,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.OILY
//            ),
//            // U02
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         77,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.COMBINATION
//            ),
//            // U03
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.OILY
//            ),
//            // U04
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        32,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U05
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        25,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.OILY
//            ),
//            // U06
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  77,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U07
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        25,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.DRY
//            ),
//            // U08
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.OILY
//            ),
//            // U09
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         77,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            ),
//            // U10
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.COMBINATION
//            ),
//            // U11
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        32,
//                            SkinState.ACNE,         32,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U12
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  85,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U13
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.COMBINATION
//            ),
//            // U14
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 77
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.DRY
//            ),
//            // U15
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.COMBINATION
//            ),
//            // U16
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        32,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U17
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      85,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         77,
//                            SkinState.SENSITIVITY,  77,
//                            SkinState.PIGMENTATION, 70
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.SENSITIVE
//            ),
//            // U18
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      32,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            ),
//            // U19
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.COMBINATION
//            ),
//            // U20
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  77,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U21
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      77,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.DRY
//            ),
//            // U22
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        32,
//                            SkinState.ACNE,         32,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U23
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      32,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 32
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.COMBINATION
//            ),
//            // U24
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        77,
//                            SkinState.ACNE,         77,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.COMBINATION
//            ),
//            // U25
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        85,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.DRY
//            ),
//            // U26
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.DRY
//            ),
//            // U27
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      32,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         77,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 32
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.COMBINATION
//            ),
//            // U28
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         32,
//                            SkinState.SENSITIVITY,  77,
//                            SkinState.PIGMENTATION, 70
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.DRY
//            ),
//            // U29
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  85,
//                            SkinState.PIGMENTATION, 32
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U30
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            ),
//            // U31
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 32
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.OILY
//            ),
//            // U32
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      32,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.COMBINATION
//            ),
//            // U33
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  77,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U34
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.DRY
//            ),
//            // U35
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         32,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.COMBINATION
//            ),
//            // U36
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.COMBINATION
//            ),
//            // U37
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.DRY
//            ),
//            // U38
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.OILY
//            ),
//            // U39
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      85,
//                            SkinState.SEBUM,        77,
//                            SkinState.ACNE,         77,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 70
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.COMBINATION
//            ),
//            // U40
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        85,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.OILY
//            ),
//            // U41
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      77,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         25,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.DRY
//            ),
//            // U42
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 85
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.COMBINATION
//            ),
//            // U43
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      77,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U44
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        77,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 70
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.COMBINATION
//            ),
//            // U45
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.SENSITIVE
//            ),
//            // U46
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         32,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.COMBINATION
//            ),
//            // U47
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         32,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            ),
//            // U48
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  32,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.COMBINATION
//            ),
//            // U49
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  77,
//                            SkinState.PIGMENTATION, 32
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U50
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      32,
//                            SkinState.SEBUM,        85,
//                            SkinState.ACNE,         32,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.OILY
//            ),
//            // U51
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.DRY
//            ),
//            // U52
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.COMBINATION
//            ),
//            // U53
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        25,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  77,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U54
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  85,
//                            SkinState.PIGMENTATION, 77
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.COMBINATION
//            ),
//            // U55
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.OILY
//            ),
//            // U56
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U57
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 70
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.DRY
//            ),
//            // U58
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        32,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U59
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      77,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.DRY
//            ),
//            // U60
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         32,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 70
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.DRY
//            ),
//            // U61
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        85,
//                            SkinState.ACNE,         77,
//                            SkinState.SENSITIVITY,  85,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            ),
//            // U62
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      32,
//                            SkinState.SEBUM,        85,
//                            SkinState.ACNE,         77,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.OILY
//            ),
//            // U63
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 70
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.SENSITIVE
//            ),
//            // U64
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        77,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 85
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.OILY
//            ),
//            // U65
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      32,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.COMBINATION
//            ),
//            // U66
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      85,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U67
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        85,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            ),
//            // U68
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.COMBINATION
//            ),
//            // U69
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.DRY
//            ),
//            // U70
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.DRY
//            ),
//            // U71
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      85,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  32,
//                            SkinState.PIGMENTATION, 77
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.DRY
//            ),
//            // U72
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.COMBINATION
//            ),
//            // U73
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      77,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  77,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U74
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      77,
//                            SkinState.SEBUM,        32,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U75
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        85,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.COMBINATION
//            ),
//            // U76
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.COMBINATION
//            ),
//            // U77
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            ),
//            // U78
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U79
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.COMBINATION
//            ),
//            // U80
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.COMBINATION
//            ),
//            // U81
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         85,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.OILY
//            ),
//            // U82
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      25,
//                            SkinState.SEBUM,        77,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.COMBINATION
//            ),
//            // U83
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            ),
//            // U84
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      32,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.COMBINATION
//            ),
//            // U85
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        77,
//                            SkinState.ACNE,         77,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 32
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.COMBINATION
//            ),
//            // U86
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.DRY
//            ),
//            // U87
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      77,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.SENSITIVE
//            ),
//            // U88
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      55,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         62,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U89
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  40,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.COMBINATION
//            ),
//            // U90
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 40
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.OILY
//            ),
//            // U91
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      47,
//                            SkinState.SEBUM,        70,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.COMBINATION
//            ),
//            // U92
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.COMBINATION
//            ),
//            // U93
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         32,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 70
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.DRY
//            ),
//            // U94
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.ACNE),
//                    SkinType.OILY
//            ),
//            // U95
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         55,
//                            SkinState.SENSITIVITY,  55,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.AGING),
//                    SkinType.DRY
//            ),
//            // U96
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      62,
//                            SkinState.SEBUM,        55,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  70,
//                            SkinState.PIGMENTATION, 62
//                    ),
//                    List.of(Concern.PIGMENTATION),
//                    SkinType.COMBINATION
//            ),
//            // U97
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      77,
//                            SkinState.SEBUM,        32,
//                            SkinState.ACNE,         40,
//                            SkinState.SENSITIVITY,  85,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.DRY),
//                    SkinType.DRY
//            ),
//            // U98
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      32,
//                            SkinState.SEBUM,        62,
//                            SkinState.ACNE,         70,
//                            SkinState.SENSITIVITY,  62,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.SENSITIVE),
//                    SkinType.SENSITIVE
//            ),
//            // U99
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      40,
//                            SkinState.SEBUM,        40,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  25,
//                            SkinState.PIGMENTATION, 47
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            ),
//            // U100
//            new TestCase(
//                    Map.of(
//                            SkinState.DRYNESS,      70,
//                            SkinState.SEBUM,        47,
//                            SkinState.ACNE,         47,
//                            SkinState.SENSITIVITY,  47,
//                            SkinState.PIGMENTATION, 55
//                    ),
//                    List.of(Concern.SEBUM),
//                    SkinType.OILY
//            )
//    );


}
