
# Debug 
``` java
java.io.FileWriter writer = new java.io.FileWriter("listCommitmentMonthIn.csv");
writer.write("parkId,monthId,dayBeforeMonthEnd,yieldClassId,isMonthPast,dayComplete," +
            "nbBooking_PYT,nbBooking_CANCEL," +
            "caBooking_PYT,caBooking_CANCEL," +
            "avgDiscount_PYT,avgDiscount_CANCEL," +
            "nbHourSold_PYT,nbHourSold_CANCEL," +
            "nbBookingCumulated_PYT,nbBookingCumulated_CANCEL," +
            "caBookingCumulated_PYT,caBookingCumulated_CANCEL," +
            "avgDiscountCumulated_PYT,avgDiscountCumulated_CANCEL," +
            "nbHourSoldCumulated_PYT,nbHourSoldCumulated_CANCEL\n"); // En-tête

for (CommitmentMonth month : listCommitmentMonth) {
    writer.write(
        month.getParkId() + "," +
        month.getMonthId() + "," +
        month.getDayBeforeMonthEnd() + "," +
        month.getYieldClassId() + "," +
        month.getIsMonthPast() + "," +
        month.getDayComplete() + "," +
        month.getNbBooking()[0] + "," + month.getNbBooking()[1] + "," +
        month.getCaBooking()[0] + "," + month.getCaBooking()[1] + "," +
        month.getAvgDiscount()[0] + "," + month.getAvgDiscount()[1] + "," +
        month.getNbHourSold()[0] + "," + month.getNbHourSold()[1] + "," +
        month.getNbBookingCumulated()[0] + "," + month.getNbBookingCumulated()[1] + "," +
        month.getCaBookingCumulated()[0] + "," + month.getCaBookingCumulated()[1] + "," +
        month.getAvgDiscountCumulated()[0] + "," + month.getAvgDiscountCumulated()[1] + "," +
        month.getNbHourSoldCumulated()[0] + "," + month.getNbHourSoldCumulated()[1] + "\n"
    );
}

writer.close();
```

``` java
java.io.FileWriter writer = new java.io.FileWriter("listBookingIn.csv");
writer.write("dateBegin, dateEnd, dateHCancel, dateHRequest, dayParamId, lengthMin, monthId, nbCars, netPrice, parkingDiscount, status, totalPrice, weekId, yieldClassId"); // En-tête

for (BookingStat booking : listBookingIn) {
    writer.write(
        booking.getDateBegin() + "," +
        booking.getDateEnd() + "," +
        booking.getDateHCancel() + "," +
        booking.getDateHRequest() + "," +
        booking.getDayparamId() + "," +
        booking.getLengthMin() + "," +
        booking.getMonthId() + "," +
        booking.getNbCars() + "," +
        booking.getNetPrice() + "," +
        booking.getParkingDiscount() + "," +
        booking.getStatus() + "," + 
        booking.getTotalPrice() + "," +
        booking.getWeekId() + "," +
        booking.getYieldClassId() + "\n"
    );
}

writer.close();
```

``` JAVA
java.io.FileWriter writer = new java.io.FileWriter("listMonthIn.csv");
writer.write("monthId,dayBeforeMonthEnd,yieldClassId," +
            "nbBooking_PYT,nbBooking_CANCEL," +
            "nbBookingCumulated_PYT,nbBookingCumulated_CANCEL\n"); // En-tête

for (ERepCommitmentMonthIn month : listEMonthIn) {
    writer.write(
        month.getMonthId() + "," +
        month.getDayBeforeMonthEnd() + "," +
        month.getYieldClassId() + "," +
        month.getAvgNbBooking()[0] + "," + month.getAvgNbBooking()[1] + "," +
        month.getAvgNbBookingCumulated()[0] + "," + month.getAvgNbBookingCumulated()[1] +"\n"
    );
}
writer.close();
```

``` java
java.io.FileWriter writer = new java.io.FileWriter("listMonthIn.csv");
writer.write("monthId,dayBeforeMonthEnd,yieldClassId," +
            "avgDiscount," +
            "avgDiscountCumulated\n"); // En-tête

for (ERepCommitmentMonthIn month : listEMonthIn) {
    writer.write(
        month.getMonthId() + "," +
        month.getDayBeforeMonthEnd() + "," +
        month.getYieldclassId() + "," +
        month.getAvgDiscount() + "," +
        month.getAvgDiscountCumulated() +"\n"
    );
}
writer.close();
```