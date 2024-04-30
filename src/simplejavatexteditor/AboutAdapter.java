package simplejavatexteditor;

public class AboutAdapter{
    private About about;

    public AboutAdapter(UI ui){
        this.about = new About(UI ui);
    }

    @Override
    public void me(){
        String aboutme =  "About Me - " + SimpleJavaTextEditor.NAME;
        String stringcontent = 
        "<html><body><p>" +
        "Author: Pierre-Henry Soria<br />" +
        "Contact me at: " +
        "<a href='mailto:" + SimpleJavaTextEditor.AUTHOR_EMAIL + "?subject=About the NotePad PH Software'>" + SimpleJavaTextEditor.AUTHOR_EMAIL + "</a>" +
                "<br /><br />" +
                "Modified By: Achintha Gunasekara<br />" +
                "Contact me at: <a href='mailto:" + SimpleJavaTextEditor.EDITOR_EMAIL + "?subject=About the NotePad PH Software'>" + SimpleJavaTextEditor.EDITOR_EMAIL + "</a>" +
        "</p></body></html>";

        this.about.me(aboutme,stringcontent);
    }
    @Override
    public void software(){
        String aboutme =  "About Me - " + SimpleJavaTextEditor.NAME;
        String stringcontent =
        "<html><body><p>" +
        "Name: " + SimpleJavaTextEditor.NAME + "<br />" +
        "Version: " + SimpleJavaTextEditor.VERSION +
        "</p></body></html>";
        this.about.software(aboutme , stringcontent);
    }
}