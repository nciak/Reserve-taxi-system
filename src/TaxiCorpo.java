
public class TaxiCorpo {

    private TaxiCar[] taxiCarTable;


    public TaxiCorpo(TaxiCar[] taxiCarTable) {
        this.taxiCarTable = taxiCarTable;
    }

    String reserveAvailableTaxi(double customerX, double customerY){



        TaxiCar bestTaxi = findBestTaxiIfExist(customerX, customerY);

        if( bestTaxi == null){
            return null;
        } else {
            bestTaxi.reserveTaxi();
            return bestTaxi.getId();
        }
        }

    private TaxiCar findBestTaxiIfExist(double customerX, double customerY) {
        double minDistance = Double.MAX_VALUE;
        TaxiCar bestTaxi = null;

        for (int i =0; i<taxiCarTable.length; i++){
            TaxiCar iTaxi = taxiCarTable[i];

            if(iTaxi.isAvailable()){
                double distance = calculateDistance(customerX, customerY, iTaxi);
                if ( distance< minDistance){
                    minDistance = distance;
                    bestTaxi = iTaxi;
                }
            }
        }
        return bestTaxi;
    }


    private double calculateDistance(double customerX, double customerY, TaxiCar iTaxi) {
        double diffX = iTaxi.getxCoord()-customerX;
        double diffY = iTaxi.getyCoord()-customerY;
        double diffXSquared = (iTaxi.getxCoord()- customerX)*(iTaxi.getxCoord()-customerX);
        double diffYSquared = (iTaxi.getyCoord()- customerY)*(iTaxi.getyCoord()-customerY);
        return Math.sqrt(diffXSquared + diffYSquared);

    }

    public  TaxiCar[] getTaxiCarTable(){
        return taxiCarTable;
    }

}
