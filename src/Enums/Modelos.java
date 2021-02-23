package Enums;
    
    public enum Modelos {
        AC("MB 1113"),
        AD("MB 1313"),
        AE("MB 1414"),
        A("MB 608"),
        AB("MB 708"),
        B("MB 709"),
        C("MB 710"),
        D("MB 712"),
        DA("MB 912"),
        E("MB 1218"),
        F("MB 1318"),
        G("MB 1620"),
        GA("MB 1621"),
        GB("MB 1618"),
        BC("MB 1718"),
        H("ATRON"),
        HA("ATRON 1319"),
        HB("ATRON 2324"),
        HC("ATRON 1635"),
        HD("ATRON 2739"),
        J("ATEGO"),
        JA("ATEGO 1419"),
        JB("ATEGO 1719"),
        JC("ATEGO 1726"),
        JD("ATEGO 2426"),
        JE("ATEGO 2430"),
        ACTROS("ACTROS"),
        ACCELO("Accelo"),
        ACCELOA("Accelo 715"),
        ACCELOB("Accelo 815"),
        ACCELOC("Accelo 915"),
        ACCELOD("Accelo 1016"),
        L("AXOR"),
        M("VW Delivery"),
        MB("VW Worker"),
        MA("VW 8-120"),
        N("VW 8-150"),
        O("VW 8-160"),
        P("VW 9-150"),
        Q("VW 9-160"),
        R("VW Constellation"),
        RC("VW Constellation 13-190"),
        TD("VW  Constellation 15-190"),
        RA("VW Constellation 24-250"),
        RB("VW Constellation 24-260"),
        T("VW 13-180 Worker"),
        TA("VW 13-190 Worker"),
        TB("VW 15-180 Worker"),
        TC("VW 15-190 Worker"),
        U("VOLVO VM"),
        V("IVECO"),
        X("FORD CARGO"),
        Z("FORD 816"),
        K("FORD 815"),
        KD("F-1000"),
        KA("F-4000"),
        KB("F-250"),
        KC("F-350"),
        YA("D-20"),
        Y("HILUX"),
        KIA("KIA"),
        W("Outros");
        
        private String label;

        Modelos(String label) {
            this.label = label;
        }

        public String toString() {
            return label;
        }
    }
    
