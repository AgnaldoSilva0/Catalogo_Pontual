package Enums;
    
    public enum Cor {
        SEMCOR("Sem Cor"),
        VERMELHO("Vermelho"),
        AZUL("Azul"),
        BRANCO("Branco"),
        AMARELO("Amarelo"),
        VERDE("Verde"),
        LARANJA("Laranja"),
        PRETO("Preto"),
        MARROM("Marrom"),
        PRATA("Prata"),
        Rocho("Rocho");
        
        private String label;

        Cor (String label) {
            this.label = label;
        }

        public String toString() {
            return label;
        }
    }
    