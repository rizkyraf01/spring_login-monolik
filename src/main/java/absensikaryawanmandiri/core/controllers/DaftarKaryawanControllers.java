package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.services.AbsensiKaryawanServices;
import absensikaryawanmandiri.core.services.DaftarKaryawanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("")
public class DaftarKaryawanControllers {


    // Daftar karyawan
    @Autowired
    private DaftarKaryawanServices daftarKaryawanServices;
    @Autowired
    private AbsensiKaryawanServices absensiKaryawanServices;

    @GetMapping("/dashboard")
    public String home(Model model){
      model.addAttribute("countkaryawan",daftarKaryawanServices.countAllKaryawan());
      model.addAttribute("karyawan", " karyawan");
        model.addAttribute("countabsen",absensiKaryawanServices.countAllAbsen());
        model.addAttribute("absen", " karyawan");
        return "dashboard";
    }

    @GetMapping("/dashboard/tabel_karyawan")
    public String tabel(Model model){
        model.addAttribute("daftarkaryawan",daftarKaryawanServices.findAll());
        return  "pages/tables/karyawan-table";
    }
    @GetMapping("/dashboard/form-register-karyawan")
    public String add(Model model){
        model.addAttribute("addKaryawan", new daftar_karyawan());
        return "pages/forms/add_form_register";
    }

    @PostMapping("/dashboard/save")
    public String save(@ModelAttribute daftar_karyawan addPegawai, RedirectAttributes redirAttrs){
        boolean check_nip = daftarKaryawanServices.checkNip(addPegawai.getNip());
        if(check_nip){
            redirAttrs.addFlashAttribute("Error", "NIP Already Exist");
//            System.out.println("NIP already Exist");
        } else {
            daftar_karyawan daftar_karyawans = daftarKaryawanServices.addKaryawan(addPegawai);
            if(daftar_karyawans != null){
                redirAttrs.addFlashAttribute("Success", "Register Successfully");
            } else {
                redirAttrs.addFlashAttribute("Error", "Failed to Register please try again");
            }
        }
        return "redirect:/dashboard/form-register-karyawan";
    }

    @GetMapping("/dashboard/delete/{id}")
    public String delete(@PathVariable("id") long id){
        daftarKaryawanServices.deleteKaryawanById(id);
        return "redirect:/dashboard/tabel_karyawan";
    }

    @GetMapping("/dashboard/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        model.addAttribute("updateKaryawan", daftarKaryawanServices.karyawanFindById(id));
        return "pages/forms/edit_form_register";
    }

    @PostMapping("/dashboard/update")
    public String update(daftar_karyawan updatePegawai, Model model){
        daftarKaryawanServices.updateKaryawan(updatePegawai);
        return "redirect:/dashboard/tabel_karyawan";
    }
}
