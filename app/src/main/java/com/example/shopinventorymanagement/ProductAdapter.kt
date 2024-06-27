// ProductAdapter.kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopinventorymanagement.Product
import com.example.shopinventorymanagement.R

class ProductAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val serialNumberTextView: TextView = itemView.findViewById(R.id.serial_number)
        val productNameTextView: TextView = itemView.findViewById(R.id.product_name)
        val editButton: ImageButton = itemView.findViewById(R.id.btnEdit)
        val deleteButton: ImageButton = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.serialNumberTextView.text = product.serialNumber
        holder.productNameTextView.text = product.name
        // Handle edit and delete button clicks if needed
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
