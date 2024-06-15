/*
StudyEnthusiasts : Hội những người ham học ko quan tâm gì cả


ban đầu bác thợ săn học hành rất kém tập trung vì bận nhìn "phò mã"
    nhưng nếu bác tham gia StudyEnthusiasts thì sẽ đc tiếp nhận ý chí 
    'học không quan tâm gì cả 'của hội
    từ đó , bác chỉ tập trung học , ko nhìn phò mã nữa ==> học đến mức bỏ ăn
    từ người bình thường => zô hội => học bỏ ăn => học ko quan tâm gì cả
 
ban đầu ngựa học hành rất kém vì vừa học vừa hú hí
    nhưng nếu ngựa tham gia StudyEnthusiasts
    thì sẽ đc tiếp nhận ý chí 'học không quan tâm gì cả 'của hội
    từ đó , ngựa chỉ tập trung học , không sợ thợ săn nữa 
    ==> học ko quan tâm mạng sống
    từ người bình thường => zô hội => học ko sợ hết => học ko quan tâm gì cả
    từ con ngựa bình thường => zô hội => học ko sợ thợ săn => học ko quan tâm mạng sống ==> học ko sợ chết

StudyEnthusiasts : hội những người đam mê học tập hơn tất cả ,
họ không quan tâm bạn là con gì , loài gì , chỉ cần bạn muốn 
thì có thể tham gia hội này
nhưng nếu tham gia thì bạn sẽ trở thành người học 'học k quan tâm gì cả'

==> interface : là 1 class chỉ quan tâm đến method , ko quan tâm props 
ở đây họ chỉ quan tâm đến việc học , còn màu tóc , nước da, học như thế nào
thì kệ mẹ em

đây là cái cớ , ko nên dùng để đúc ra một đối tượng (object)
*/
package data;
public interface StudyEnthusiasts {
    //ai cũng có thể tham gia hội này chỉ cần muốn là được
    //nhưng nếu mà đã tham gia thì phải "ham học hơn tất cả"
    // ==> interface ko có props
    // nhưng nếu anh cố tình tạo thuộc tính thì sao ?
    public int FAN =3 ;
    //hay còn gọi là public static final int FAN = 5;
    //tất cả prop được tạo ra đều được hiểu là final
    //final == const hằng số , có sẵn giá trị
    //=> không có một cái ngăn (props) nào của interface là không có giá trị
    //=> dẫn đến việc trong interface ko có constructor, vì ngăn nào cũng là
    // final ==> có giá trị , thì ko có ngăn nào cần rót giá trị vào cả
    // không có getter và setter
    // sẽ có sẳn constructor default(rỗng)
    
    //tất cả các method trong interface đều là abstract method
    //dù có từ khóa abstract hay ko 
   
    public double studyHard();
    //tại sao method trong interface đều là abstract method 
    // vì interface là một cái cớ để gom 2 class ko có điểm chung về chung 1 nhóm 
    // đã không có điểm chung thì lấy đâu ra công thức chung => phải bỏ trống
    // quy tắc : đã nói xạo thì sao dám nói chi tiết được
    
    public void showProfile();
}
//trong interface thì ko nên có 2 method 
//nên có 1 method 
 