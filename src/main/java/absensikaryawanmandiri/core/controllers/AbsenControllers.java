package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.services.AbsensiKaryawanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class AbsenControllers {
    @Autowired
    private AbsensiKaryawanServices absensiKaryawanServices;

    // Absen Karyawan
    @GetMapping("/dashboard/table-absen")
    public String absenlist(Model model){
        model.addAttribute("daftarabsen",absensiKaryawanServices.findAll());
        return "pages/tables/absen-table";
    }

    @GetMapping("/add/absen")
    public String add(Model model){
        model.addAttribute("addAbsensi", new absensi_karyawan());
        return "pages/forms/absen";
    }

    @PostMapping("/save/absen")
    public String save(@ModelAttribute("addAbsensi") absensi_karyawan addAbsensis, daftar_karyawan checkNipKaryawan, RedirectAttributes redirAttrs) {

        boolean checkNipAbsenKaryawan = absensiKaryawanServices.checkNipAbsen(addAbsensis.getNip());
        boolean checkNip = absensiKaryawanServices.checkNip(checkNipKaryawan.getNip());
        System.out.println(checkNipAbsenKaryawan);

        if (checkNip) {
            if (checkNipAbsenKaryawan) {
                redirAttrs.addFlashAttribute("Error", "Sudah Absen Hari ini, Tolong Absen Besok Lagi");
            } else {
                absensi_karyawan absensi_karyawans = absensiKaryawanServices.addAbsensi(addAbsensis);
                if (absensi_karyawans != null) {
                    redirAttrs.addFlashAttribute("Success", "Absen Telah Berhasil");
                } else {
                    redirAttrs.addFlashAttribute("Error", "Gagal Absen Mohon Dicoba Lagi");
                }
            }
        } else {
            redirAttrs.addFlashAttribute("Error", "NIP Tidak Tersedia Mohon Hubungi Admin");
        }

        return "redirect:/add/absen";
    }
}
