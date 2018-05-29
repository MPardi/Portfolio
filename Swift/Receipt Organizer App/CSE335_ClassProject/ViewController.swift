//
//  ViewController.swift
//  CSE335_ClassProject
//
//  Created by Michael Pardi on 3/28/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//

import UIKit
import CoreData
import GooglePlacePicker

class ViewController: UIViewController, GMSPlacePickerViewControllerDelegate {
    let context = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    
    @IBOutlet weak var login: UIButton!
    @IBOutlet weak var logout: UIButton!
    @IBOutlet weak var viewReceiptsBtn: UIButton!
    @IBOutlet weak var logo: UIImageView!
    @IBOutlet var backgroundView: UIView!
    @IBOutlet weak var welcomeLabel: UILabel!
    
    var userWasCreated: Bool = false
    
    var userLoggedIn = false
    var userName: String = ""
    
    let logoImage = UIImage(named: "Logo.png")
    let gradientLayer = CAGradientLayer()
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        navigationController?.setNavigationBarHidden(true, animated: true)
        
        
        if userWasCreated {
            var successAlert = UIAlertController(title: "Alert", message: "User Successfully Created", preferredStyle: UIAlertControllerStyle.alert)
            let okAction = UIAlertAction(title: "OK", style: UIAlertActionStyle.default) { action in
                self.dismiss(animated: true, completion: nil)
            }
            successAlert.addAction(okAction)
            self.present(successAlert, animated: true, completion: nil)
            
            userWasCreated = false
        }
        
        if userLoggedIn {
            login.isHidden = true
            logout.isHidden = false
            welcomeLabel.text = "Welcome \(userName), Please Make A Selection"
        }
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(true)
        navigationController?.setNavigationBarHidden(false, animated: false)
    }
    
    override func viewDidLayoutSubviews() {
        gradientLayer.frame = self.backgroundView.bounds
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let color1 = UIColor(red: 0.13, green: 1.0, blue: 0.78, alpha: 0.5)
        let color2 = UIColor(red: 0.8, green: 0.39, blue: 0.8, alpha: 0.7)
        
        gradientLayer.colors = [color1.cgColor, color2.cgColor]
        backgroundView.layer.addSublayer(gradientLayer)
        backgroundView.layer.cornerRadius = backgroundView.bounds.width / 2
        gradientLayer.cornerRadius = backgroundView.bounds.width / 2
        
        logo.image = logoImage
        
        logout.isHidden = true
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func shouldPerformSegue(withIdentifier identifier: String, sender: Any?) -> Bool {
        if identifier == "toStoredReceipts" {
            if userLoggedIn {
                welcomeLabel.text = "Welcome \(userName),Please Make A Selection"
                return true
            }
            else {
                var loginAlert = UIAlertController(title: "Alert", message: "Please Login or Create a User", preferredStyle: UIAlertControllerStyle.alert)
                let okAction = UIAlertAction(title: "OK", style: UIAlertActionStyle.default) { action in
                    self.dismiss(animated: true, completion: nil)
                }
                loginAlert.addAction(okAction)
                self.present(loginAlert, animated: true, completion: nil)
                
                return false
            }
        }
        
        return true
    }
    
    @IBAction func logoutBtn(_ sender: UIButton) {
        userLoggedIn = false
        logout.isHidden = true
        login.isHidden = false
    }
    
    // The code snippet below shows how to create and display a GMSPlacePickerViewController.
    @IBAction func pickPlace(_ sender: UIButton) {
        let config = GMSPlacePickerConfig(viewport: nil)
        let placePicker = GMSPlacePickerViewController(config: config)
        placePicker.delegate = self
        
        present(placePicker, animated: true, completion: nil)
    }
    
    // To receive the results from the place picker 'self' will need to conform to
    // GMSPlacePickerViewControllerDelegate and implement this code.
    func placePicker(_ viewController: GMSPlacePickerViewController, didPick place: GMSPlace) {
        // Dismiss the place picker, as it cannot dismiss itself.
        viewController.dismiss(animated: true, completion: nil)
        
        print("Place name \(place.name)")
        print("Place address \(place.formattedAddress)")
        print("Place attributions \(place.attributions)")
    }
    
    func placePickerDidCancel(_ viewController: GMSPlacePickerViewController) {
        // Dismiss the place picker, as it cannot dismiss itself.
        viewController.dismiss(animated: true, completion: nil)
        
        print("No place selected")
    }
    
    @IBAction func unwindToAddUser(sender: UIStoryboardSegue) {
        
    }
    
    @IBAction func unwindToLogin(sender: UIStoryboardSegue) {
        
    }

}

