package com.developer.eric.voiceandtextmessenger.views

import android.util.Log
import com.developer.eric.voiceandtextmessenger.R
import com.developer.eric.voiceandtextmessenger.models.User
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.chat_from_row.view.*
import kotlinx.android.synthetic.main.chat_to_row.view.*

class ChatToItem(val text: String, val user: User): Item<ViewHolder>() {
    override fun getLayout(): Int {
        Log.d("ChatLog", "getting ChatTo layout")
        return R.layout.chat_to_row
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textViewChatToRow.text = text

        // load our user image
        val uri = user.profileImageUrl
        val targetImageView = viewHolder.itemView.imageViewChatToRow
        Picasso.get().load(uri).into(targetImageView)

        Log.d("ChatLog", "binding to view holder")
    }

}

class ChatFromItem(val text: String, val user: User): Item<ViewHolder>() {
    override fun getLayout(): Int {
        Log.d("ChatLog", "getting ChatFrom layout")
        return R.layout.chat_from_row
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textViewChatFromRow.text = text

        // load user image
        val uri = user.profileImageUrl
        val targetImageView = viewHolder.itemView.imageViewChatFromRow
        Picasso.get().load(uri).into(targetImageView)
        Log.d("CHAT LOG ACTIVITY", "binding from view holder")
    }

}
