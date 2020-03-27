package challenge;

public class CriptografiaCesariana implements Criptografia {

    int casas = 3;

    @Override
    public String criptografar(String texto) {
        return this.cesariana(texto, casas);
    }

    @Override
    public String descriptografar(String texto) {
        return this.cesariana(texto, -(casas));
    }

    private String cesariana(String texto, int casas){
        if(texto.isEmpty()){
            throw new  IllegalArgumentException("Você deve informar um texto diferente de nullo ou vazio");
        }

        String lowerTexto = texto.toLowerCase();
        String cifra = "";

        for(int i=0; i<lowerTexto.length(); i++){
            int codePoint = (int) lowerTexto.charAt(i);

            if(codePoint >=97 && codePoint<= 122){
                if(casas > 0){
                    if(codePoint > (122 - casas)){
                        cifra += (char) ((codePoint - 26) + casas);
                    }else {
                        cifra += (char) (codePoint  + casas);
                    }
                }else{
                    if(codePoint < (97 + casas)){
                        cifra += (char) ((codePoint + 26) + (-(casas)));
                    }else {
                        cifra += (char) (codePoint  - (-(casas)));
                    }
                }
            }else{
                cifra += (char) codePoint;
            }
        }
        return cifra;
    }

    public static void main(String[] args){

        CriptografiaCesariana criptografiaCesariana = new CriptografiaCesariana();

        System.out.println(criptografiaCesariana.criptografar("1TESTE DE CRIPTOGRAFIA2"));
        System.out.println( criptografiaCesariana.descriptografar(criptografiaCesariana.criptografar("1TESTE DE CRIPTOGRAFIA2")));

    }
}
