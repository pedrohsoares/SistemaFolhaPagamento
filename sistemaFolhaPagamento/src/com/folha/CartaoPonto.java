package com.folha;

import java.util.Calendar;

public class CartaoPonto {
	private Calendar dataHoraInicio;
	private Calendar dataHoraTermino;

	public CartaoPonto(Calendar inicio, Calendar termino) {
		this.dataHoraInicio = inicio;
		this.dataHoraTermino = termino;
	}

	public Calendar getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Calendar dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Calendar getDataHoraTermino() {
		return dataHoraTermino;
	}

	public void setDataHoraTermino(Calendar dataHoraTermino) {
		this.dataHoraTermino = dataHoraTermino;
	}
	
	

}
