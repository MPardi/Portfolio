//
//  ReceiptDetailViewController.swift
//  CSE335_ClassProject
//
//  Created by Michael Pardi on 4/23/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//

import UIKit
import GooglePlacePicker
import CoreLocation

class ReceiptDetailViewController: UIViewController, GMSPlacePickerViewControllerDelegate, UINavigationControllerDelegate {
    
    var placesClient: GMSPlacesClient!
    @IBOutlet weak var itemImage: UIImageView!
    var image: UIImage!
    @IBOutlet weak var itemField: UILabel!
    var item: String!
    @IBOutlet weak var locationField: UILabel!
    var location: String!
    @IBOutlet weak var costField: UILabel!
    var cost: String!
    @IBOutlet weak var storeField: UILabel!
    var store: String!
    
    let geoCoder = CLGeocoder()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        itemImage.image = image
        itemField.text = item
        locationField.text = location
        costField.text = cost
        storeField.text = store
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    @IBAction func selectLocation(_ sender: UIButton) {
        geoCoder.geocodeAddressString(location) {
            placemarks, error in
            let placemark = placemarks?.first
            let lat = placemark?.location?.coordinate.latitude
            let lon = placemark?.location?.coordinate.longitude
            
            let center = CLLocationCoordinate2D(latitude: lat!, longitude: lon!)
            let northEast = CLLocationCoordinate2D(latitude: center.latitude + 0.001,
                                                   longitude: center.longitude + 0.001)
            let southWest = CLLocationCoordinate2D(latitude: center.latitude - 0.001,
                                                   longitude: center.longitude - 0.001)
            let viewport = GMSCoordinateBounds(coordinate: northEast, coordinate: southWest)
            
            let config = GMSPlacePickerConfig(viewport: viewport)
            let placePicker = GMSPlacePickerViewController(config: config)
            placePicker.delegate = self
            
            self.present(placePicker, animated: true, completion: nil)
        }
    }
    
    // To receive the results from the place picker 'self' will need to conform to
    // GMSPlacePickerViewControllerDelegate and implement this code.
    func placePicker(_ viewController: GMSPlacePickerViewController, didPick place: GMSPlace) {
        // Dismiss the place picker, as it cannot dismiss itself.
        viewController.dismiss(animated: true, completion: nil)
    }
    
    func placePickerDidCancel(_ viewController: GMSPlacePickerViewController) {
        // Dismiss the place picker, as it cannot dismiss itself.
        viewController.dismiss(animated: true, completion: nil)
        
        print("No place selected")
    }
}
