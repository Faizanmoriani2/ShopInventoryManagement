// ProductAdapter.kt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.example.shopinventorymanagement.Product
import com.example.shopinventorymanagement.contract.Product
import com.example.shopinventorymanagement.R

class ProductAdapter(var context: Context, val productList: MutableList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val barcode: TextView = itemView.findViewById(R.id.barcode)
        val productNameTextView: TextView = itemView.findViewById(R.id.product_name)
        val txtStock: TextView = itemView.findViewById(R.id.txtStock)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
        val editButton: ImageButton = itemView.findViewById(R.id.btnEdit)
        val deleteButton: ImageButton = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.barcode.text = product.barcode
        holder.productNameTextView.text = product.name
        holder.txtPrice.text = product.price
        holder.txtStock.text = product.stock

        // Handle edit and delete button clicks here

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
