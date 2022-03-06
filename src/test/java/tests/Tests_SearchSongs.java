package tests;

import com.yousician.pages.SeachSongs;
import org.testng.annotations.*;
import utils.TestData;

import java.io.IOException;

public class Tests_SearchSongs extends BaseTestClass {


    static TestData testData;
    SeachSongs searchingSongs;

    @Test(priority = 0)
    public void SearchingSongsBySongName() throws IOException {
        testData = new TestData();
        searchingSongs = new SeachSongs(driver);

        driver.get(testData.properties.getProperty("baseUrl") );
        searchingSongs.SearchSong("dua lipa");
        searchingSongs.GetSongsByName();

    }

    @Test(priority = 1)
    public void SearchingSongsByArtist() throws IOException {
        testData = new TestData();
        searchingSongs = new SeachSongs(driver);

        driver.get(testData.properties.getProperty("baseUrl"));
        searchingSongs.SearchSong("dua lipa");
        searchingSongs.GetSongsByArtist();
    }
}
