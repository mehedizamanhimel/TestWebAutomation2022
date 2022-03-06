package com.yousician.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class SeachSongs {
    WebDriver driver;

    public SeachSongs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//INPUT[@value='']")
    public WebElement text_search;

    @FindBy(css = "button[type='submit']")
    public WebElement button_search;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[1]/div[2]/a/div[2]/p")
    List<WebElement> list_Song_Artist;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[1]/div[2]/a/div[1]/p")
    List<WebElement> list_Song_Name;

    //This method to type keyword from test case class and click search button.
    public void SearchSong(String keyword){
        text_search.sendKeys(keyword);
        System.out.println("Your search keyword is: " + keyword);
        button_search.click();
    }


    /*
    Getting the listed songs,
    Converting the webelement list to an array
    printing out the regular list,
    Sorting the list
    printing out the sorted list
     */
    public void GetSongsByName(){
        String[] arr = new String[list_Song_Name.size()];
        for(int i = 0; i < list_Song_Name.size(); i++){
            arr[i] = String.valueOf(list_Song_Name.get(i).getText());
           //System.out.println(list_Song_Name.get(i).getText());
        }
        System.out.println("The song list by song name before sorting: "+"\n"+ Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("The song list by song name after sorting: "+"\n"+ Arrays.toString(arr));

    }


    public void GetSongsByArtist(){
        String[] arr = new String[list_Song_Artist.size()];
        for(int i = 0; i < list_Song_Artist.size(); i++){
            arr[i] = String.valueOf(list_Song_Artist.get(i).getText());
            //System.out.println(list_Song_Name.get(i).getText());
        }
        System.out.println("The song list by song name before sorting: "+"\n"+ Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("The song list by song name after sorting: "+"\n"+ Arrays.toString(arr));

    }




}
