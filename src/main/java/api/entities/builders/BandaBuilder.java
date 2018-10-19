package api.entities.builders;

import api.entities.Banda;
import api.entities.Musico;

import java.time.LocalDateTime;
import java.util.List;

public class BandaBuilder {
    private Banda banda;

    public BandaBuilder(Banda banda) {
        this.banda = banda;
    }

    public BandaBuilder nombre(String nombre) {
        this.banda.setNombre(nombre);
        return this;
    }

    public BandaBuilder direccion(String direccion) {
        this.banda.setDireccion(direccion);
        return this;
    }

    public BandaBuilder email(String email) {
        this.banda.setEmail(email);
        return this;
    }

    public BandaBuilder fechaFundacion(LocalDateTime fechaFundacion) {
        this.banda.setFechaFundacion(fechaFundacion);
        return this;
    }

    public BandaBuilder musicos(List<Musico> musicos) {
        this.banda.setMusicos(musicos);
        return this;
    }

    public Banda build() {
        return this.banda;
    }

}
