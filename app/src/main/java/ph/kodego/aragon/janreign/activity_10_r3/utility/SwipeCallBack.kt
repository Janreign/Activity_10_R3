package ph.kodego.aragon.janreign.activity_10_r3.utility

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ph.kodego.aragon.janreign.activity_10_r3.adapter.StudentAdapter

class SwipeCallback (dragDirs: Int, swipeDirs: Int) :
    ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
    var studentAdapter: StudentAdapter? = null
    var background: ColorDrawable = ColorDrawable(Color.BLACK)

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        studentAdapter!!.removeStudent(position)
    }

    override fun onChildDraw(
        canvas: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    )
    {

        super.onChildDraw(
            canvas,
            recyclerView,
            viewHolder,
            dX,
            dY,
            actionState,
            isCurrentlyActive)

        val itemView= viewHolder.itemView

        if (dX > 0) {//Swiping to the right
            background = ColorDrawable(Color.LTGRAY)
            background.setBounds(
                itemView.left, itemView.top, itemView.left + dX.toInt(),
                itemView.bottom
            )
        }else if (dX < 0) {//swipingto the left
            // }
            background = ColorDrawable(Color.DKGRAY)
            background.setBounds(
                itemView.right + dX.toInt(),
                itemView.top, itemView.right, itemView.bottom)
        }else {
            background.setBounds(0,0,0,0)
        }
        background.draw(canvas)
    }

}