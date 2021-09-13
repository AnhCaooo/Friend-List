package com.example.FriendList.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FriendList.domain.Friend;

@Controller
public class FriendListController {

	private List<Friend> friends = new ArrayList<Friend>();

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(@RequestParam(name = "friend", required = false) String name, Model model) {
		friends = new ArrayList<Friend>();
		Friend friend = new Friend();
		model.addAttribute("friend", friend);
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@ModelAttribute(name = "friend") Friend friend, Model model) {
		friends.add(friend);
		model.addAttribute("friends", friends);

		friend = new Friend();
		model.addAttribute("friend", friend);
		return "index";
	}
}
