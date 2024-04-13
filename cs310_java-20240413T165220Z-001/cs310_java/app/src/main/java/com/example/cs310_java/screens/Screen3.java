package com.example.cs310_java.screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs310_java.adapter.CommentAdapter;
import com.example.cs310_java.databinding.FragmentScreen3Binding;
import com.example.cs310_java.model.Comment;
import com.example.cs310_java.viewmodel.SharedViewModel;

import java.util.ArrayList;
import java.util.List;

public class Screen3 extends Fragment {
    private FragmentScreen3Binding binding;

    private RecyclerView recyclerViewComments;

    private CommentAdapter commentsAdapter;

    private List<Comment> commentList = new ArrayList<>();
    private SharedViewModel viewModel;

    public Screen3() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentScreen3Binding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        binding.buttonSubmit.setOnClickListener(v -> {
            String name = binding.editTextName.getText().toString();
            String comment = binding.editTextComment.getText().toString();
            addComment(name, comment);
        });
        recyclerViewComments = binding.recyclerViewComments;
        commentsAdapter = new CommentAdapter(commentList);
        recyclerViewComments.setAdapter(commentsAdapter);
        recyclerViewComments.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.backButton.setOnClickListener(v -> goBack());
        return binding.getRoot();
    }

    private void addComment(String name, String comment) {
        Comment newComment = new Comment(name, comment);
        commentList.add(newComment);
        commentsAdapter.notifyItemInserted(commentList.size() - 1);
        recyclerViewComments.scrollToPosition(commentList.size() - 1);
    }

    private void goBack() {
        requireActivity().onBackPressed();
    }

}