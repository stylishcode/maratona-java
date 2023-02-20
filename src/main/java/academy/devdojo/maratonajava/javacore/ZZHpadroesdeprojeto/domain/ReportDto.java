package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.domain;

public class ReportDto {
    private String aircraftName;
    private Country country;
    private String currencySymbol;
    private String personName;

    public ReportDto(String aircraftName, Country country, String currencySymbol, String personName) {
        this.aircraftName = aircraftName;
        this.country = country;
        this.currencySymbol = currencySymbol;
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "aircraftName='" + aircraftName + '\'' +
                ", country=" + country +
                ", currencySymbol=" + currencySymbol +
                ", personName='" + personName + '\'' +
                '}';
    }

    public static final class ReportDtoBuilder {
        private String aircraftName;
        private Country country;
        private String currencySymbol;
        private String personName;

        private ReportDtoBuilder() {
        }

        public static ReportDtoBuilder builder() {
            return new ReportDtoBuilder();
        }

        public ReportDtoBuilder aircraftName(String aircraftName) {
            this.aircraftName = aircraftName;
            return this;
        }

        public ReportDtoBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public ReportDtoBuilder currency(String currencySymbol) {
            this.currencySymbol = currencySymbol;
            return this;
        }

        public ReportDtoBuilder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public ReportDto build() {
            return new ReportDto(aircraftName, country, currencySymbol, personName);
        }

    }

}
