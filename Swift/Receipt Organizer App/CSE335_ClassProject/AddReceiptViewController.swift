//
//  AddReceiptViewController.swift
//  CSE335_ClassProject
//
//  Created by Michael Pardi on 3/28/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//

import UIKit
import CoreData

class AddReceiptViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, UINavigationControllerDelegate {
    
    @IBOutlet weak var receiptTable: UITableView!
    let context = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    var fetchedResults = [Receipts]()
    var userResults = [Users]()
    let formatter = NumberFormatter()
    
    func fetchReceiptData() -> Int {
        let fetchRequest = NSFetchRequest<NSFetchRequestResult>(entityName: "Receipts")
        var x = 0
        
        fetchedResults = ((try? context.fetch(fetchRequest)) as? [Receipts])!
        
        x = fetchedResults.count
        
        print(fetchedResults.count)
        
        return x
    }
    
    func fetchUserData() -> Int {
        let fetchRequest = NSFetchRequest<NSFetchRequestResult>(entityName: "Users")
        var x = 0
        
        userResults = ((try? context.fetch(fetchRequest)) as? [Users])!
        
        x = userResults.count
        
        return x
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return fetchReceiptData();
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = receiptTable.dequeueReusableCell(withIdentifier: "receiptCell", for: indexPath) as! ReceiptTableViewCell
        
        cell.layer.borderWidth = 0.8
        
        cell.receiptItem.text = fetchedResults[indexPath.row].item
        
        if let cost = formatter.string(from: fetchedResults[indexPath.row].total! as NSNumber) {
            cell.receiptTotal.text = "\(cost)"
        }
        
        cell.receiptStore.text = fetchedResults[indexPath.row].store
        cell.receiptLocation.text = fetchedResults[indexPath.row].location
        
        if let data = fetchedResults[indexPath.row].image {
            cell.receiptImage.image = UIImage(data: data as Data)
            
        }
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 125.0
    }
    
    // delete table entry
    func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool
    {
        return true
    }
    
    func tableView(_ tableView: UITableView, editingStyleForRowAt indexPath: IndexPath) -> UITableViewCellEditingStyle
    {
        return UITableViewCellEditingStyle.delete
    }
    
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath)
    {
        if editingStyle == .delete {
            context.delete(fetchedResults[indexPath.row])
            
            fetchedResults.remove(at: indexPath.row)
            
            do {
                try context.save()
            } catch {
                
            }
            
            receiptTable.reloadData()
        }
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "detailView" {
            let selectedIndex: IndexPath = self.receiptTable.indexPath(for: sender as! ReceiptTableViewCell)!

            let receipt = fetchedResults[selectedIndex.row]

            if let viewController: ReceiptDetailViewController = segue.destination as? ReceiptDetailViewController {
                viewController.item = receipt.item
                if let cost = formatter.string(from: receipt.total! as NSNumber) {
                    viewController.cost = "\(cost)"
                }
                
                if let data = receipt.image {
                    viewController.image = UIImage(data: data as Data)
                    
                }
                
                viewController.store = receipt.store
                viewController.location = receipt.location
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print("There are \(fetchUserData()) users.")
        print("There are \(fetchReceiptData()) receipts")
        
        formatter.numberStyle = .currency
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func unwindToAddReceipt(sender: UIStoryboardSegue) {
        receiptTable.reloadData()
    }
    
}
