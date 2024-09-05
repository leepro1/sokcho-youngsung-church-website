package com.sokchoys.domain.notice.controller;

import com.sokchoys.domain.notice.entity.Notice;
import com.sokchoys.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public String listNotices(Model model) {
        List<Notice> notices = noticeService.findAllNotices();
        model.addAttribute("notices", notices);
        return "notice/list";
    }

    @GetMapping("/{id}")
    public String viewNotice(@PathVariable Long id, Model model) {
        Notice notice = noticeService.findNoticeById(id)
            .orElseThrow(() -> new IllegalArgumentException("공지사항을 찾을 수 없습니다."));
        model.addAttribute("notice", notice);
        return "notice/view";
    }

    @GetMapping("/new")
    public String createNoticeForm() {
        return "notice/new";
    }

    @PostMapping
    public String createNotice(@ModelAttribute Notice notice) {
        noticeService.createNotice(notice.getTitle(), notice.getContent(), notice.getAuthor());
        return "redirect:/notices";
    }

    @GetMapping("/{id}/edit")
    public String editNoticeForm(@PathVariable Long id, Model model) {
        Notice notice = noticeService.findNoticeById(id)
            .orElseThrow(() -> new IllegalArgumentException("공지사항을 찾을 수 없습니다."));
        model.addAttribute("notice", notice);
        return "notice/edit";
    }

    @PostMapping("/{id}")
    public String updateNotice(@PathVariable Long id, @ModelAttribute Notice notice) {
        noticeService.updateNotice(id, notice.getTitle(), notice.getContent());
        return "redirect:/notices";
    }

    @PostMapping("/{id}/delete")
    public String deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return "redirect:/notices";
    }
}
