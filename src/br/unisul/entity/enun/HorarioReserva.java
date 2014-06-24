package br.unisul.entity.enun;

public enum HorarioReserva {

    HORA_18("18h"), HORA_19("19h"), HORA_20("20h"), HORA_21("21h"), HORA_22("22h");

    HorarioReserva(String descricao) {

        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public static HorarioReserva getByString(String value) {

        try {

            return HorarioReserva.valueOf(value);

        } catch (Exception e) {

            return null;
        }
    }
}
