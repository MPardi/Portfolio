//
//  MenuViewController.swift
//  Project2_1
//
//  Created by Michael Pardi on 4/5/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class MenuViewController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate {
    
    let colors = Colors()
    
    override func viewWillAppear(_ animated: Bool) {
        navigationController?.isNavigationBarHidden = true
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        navigationController?.isNavigationBarHidden = false
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        refresh()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func refresh() {
        view.backgroundColor = UIColor.clear
        let backgroundLayer = colors.gl
        backgroundLayer.frame = view.frame
        view.layer.insertSublayer(backgroundLayer, at: 0)
    }
    
    @IBAction func cameraButton(_ sender: UIButton) {
        let imagePicker = UIImagePickerController()
        
        if UIImagePickerController.isSourceTypeAvailable(.camera) {
            imagePicker.sourceType = .camera
            imagePicker.showsCameraControls = true
            
            let overlayRect = CGRect(x: 0.0, y: 0.0, width: view.frame.width, height: view.frame.height - 44.0)
            imagePicker.cameraOverlayView = CustomCameraView(frame: overlayRect)
            
            imagePicker.delegate = self
            
            present(imagePicker, animated: true, completion: nil)
        }
    }
    
    
    @IBAction func libraryButtonAction(_ sender: UIButton) {
        let imagePicker = UIImagePickerController()
        imagePicker.sourceType = .photoLibrary
        
        imagePicker.delegate = self
        
        present(imagePicker, animated: true, completion: nil)
    }
    
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : Any]) {
        let image = info[UIImagePickerControllerOriginalImage]
        
        //Creates instance of OCR object.
        let ocrInstance = OCRAttempt(image: image as! UIImage)
        
        //Creates viewcontoller instance.
        let imageTextDisplay = storyboard?.instantiateViewController(withIdentifier: "Image To Text Display") as! ImageToTextDisplayViewController
        
        //Sets String to return value of OCR processing function
        imageTextDisplay.ocrString = ocrInstance.process()
        
        //Changes viewcontroller
        navigationController?.pushViewController(imageTextDisplay, animated: true)
        
        //Closes camera overlay.
        dismiss(animated: true, completion: nil)
    }
}
