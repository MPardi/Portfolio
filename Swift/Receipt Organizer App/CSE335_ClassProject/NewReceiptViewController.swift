//
//  NewReceiptViewController.swift
//  CSE335_ClassProject
//
//  Created by student on 3/30/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//

import UIKit
import CoreData
import GooglePlacePicker

class NewReceiptViewController: UIViewController, GMSPlacePickerViewControllerDelegate, UIImagePickerControllerDelegate, UINavigationControllerDelegate {
    let picker = UIImagePickerController ()
    @IBOutlet weak var itemField: UITextField!
    var storeField: String = ""
    var location: String = ""
    @IBOutlet weak var totalCostField: UITextField!
    @IBOutlet weak var receiptImage: UIImageView! {
        didSet {
            receiptImage.layer.cornerRadius = 10
            receiptImage.clipsToBounds = true
        }
    }
    @IBOutlet weak var saveButton: UIBarButtonItem!
    @IBOutlet weak var sourceSelector: UISegmentedControl!
    @IBOutlet weak var locationField: UITextField!
    
    var selectedImage: UIImage?
    
    let formatter = NumberFormatter()
    
    let context = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    
    let fetchedResults = [Receipts]()

    override func viewDidLoad() {
        super.viewDidLoad()
        picker.delegate = self
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : Any]) {
        picker .dismiss(animated: true, completion: nil)
        selectedImage = info[UIImagePickerControllerOriginalImage] as? UIImage
        receiptImage.image = selectedImage
    }
    
    func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
        dismiss(animated: true, completion: nil)
    }
    
    @IBAction func imageTaker(_ sender: UIButton) {
        if sourceSelector.selectedSegmentIndex == 0 {
            if UIImagePickerController.isSourceTypeAvailable(.camera) {
                picker.allowsEditing = false
                picker.sourceType = UIImagePickerControllerSourceType.camera
                picker.cameraCaptureMode = .photo
                picker.modalPresentationStyle = .fullScreen
                present(picker,animated: true,completion: nil)
            }
            else {
                print("No camera")
            }
        }
        else {
            picker.allowsEditing = false
            picker.sourceType = .photoLibrary
            picker.mediaTypes = UIImagePickerController.availableMediaTypes(for: .photoLibrary)!
            picker.modalPresentationStyle = .popover
            present(picker, animated: true, completion: nil)
        }
    }
    
    @IBAction func selectLocation(_ sender: UIButton) {
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
        storeField = place.name
        print("Place address \(place.formattedAddress!)")
        locationField.text = place.formattedAddress!
        location = place.formattedAddress!
    }
    
    func placePickerDidCancel(_ viewController: GMSPlacePickerViewController) {
        // Dismiss the place picker, as it cannot dismiss itself.
        viewController.dismiss(animated: true, completion: nil)
        
        print("No place selected")
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        super.prepare(for: segue, sender: sender)
        
        guard let button = sender as? UIBarButtonItem, button === saveButton else {
            return
        }
        
        if (itemField.text != "" && storeField != "" && totalCostField != nil) {
            let ent = NSEntityDescription.entity(forEntityName: "Receipts", in: self.context)
            
            let newItem = Receipts(entity: ent!, insertInto: self.context)
            
            newItem.item = itemField.text
            newItem.store = storeField
            newItem.location = location
            
            formatter.generatesDecimalNumbers = true
            let cost = formatter.number(from: totalCostField.text!) as? NSDecimalNumber
            newItem.total = cost
            
            if self.receiptImage.image != nil {
                let finalReceiptImage = UIImagePNGRepresentation(receiptImage.image!) as NSData?
                newItem.image = finalReceiptImage
            }
            
            do {
                try self.context.save()
            } catch _ {
                
            }
        }
    }

}
