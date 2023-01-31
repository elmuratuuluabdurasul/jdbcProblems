package org.example;

import org.example.model.Restourant;
import org.example.service.RestourantService;
import org.example.service.RestourantServiceImpl;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        RestourantService restourantService = new RestourantServiceImpl();
        //restourantService.createTable();
        //restourantService.saveRestourant(new Restourant(4L,"eki das","osh bazar 122",  "04-01-2023"));
        //System.out.println(restourantService.findById(2L));
        //System.out.println(restourantService.getAllRestourants());
        //restourantService.updateRestourant(4L, new Restourant(1L,"Kut","hfukjgso","01-01-1999"));
        restourantService.deleteRestourants();
    }
}
