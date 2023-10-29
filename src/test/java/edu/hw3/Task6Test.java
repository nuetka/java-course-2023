package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import edu.hw3.Task6.StockMarketImpl;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    public void testAddStock() {
        StockMarket stockMarket = new StockMarketImpl();
        Stock stock1 = new Stock("AAPL", 150.0);
        stockMarket.add(stock1);

        assertThat(stockMarket.mostValuableStock()).isEqualTo(stock1);
    }

    @Test
    public void testRemoveStock() {
        StockMarket stockMarket = new StockMarketImpl();
        Stock stock1 = new Stock("AAPL", 150.0);
        Stock stock2 = new Stock("GOOG", 2800.0);
        stockMarket.add(stock2);
        stockMarket.add(stock1);

        stockMarket.remove(stock2);

        assertThat(stockMarket.mostValuableStock()).isEqualTo(stock1);
    }

    @Test
    public void testMostValuableStock() {
        StockMarket stockMarket = new StockMarketImpl();
        Stock stock1 = new Stock("AAPL", 150.0);
        Stock stock2 = new Stock("GOOG", 2800.0);
        Stock stock3 = new Stock("TSLA", 700.0);
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        assertThat(stockMarket.mostValuableStock()).isEqualTo(stock2);
    }

    @Test
    public void testMostValuableStockWithEmptyMarket() {
        StockMarket stockMarket = new StockMarketImpl();

        assertThat(stockMarket.mostValuableStock()).isNull();
    }
}
